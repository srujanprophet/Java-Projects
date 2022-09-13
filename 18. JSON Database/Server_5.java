package server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.gson.Gson;

class Command {
    private final String type;
    private final String key;
    private final String value;

    public Command(String type, String key, String value) {
        this.type = type; this.key = key; this.value = value;
    }

    public String getType() { return type; }
    public String getKey() { return key; }
    public String getValue() { return value; }
}

class DBEntry {
    private final String key;
    private final String value;

    public DBEntry(String key, String value) {
        this.key = key; this.value = value;
    }

    public String getKey() { return key; }
    public String getValue() { return value; }

}

class ClientHandler implements Callable<String> {
    static Gson gson = new Gson();
    private Command cmd;
    private String sentMsg = "";

    static final String dbFile = "src/server/data/db.json";
    static ReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();
    static Lock writeLock = lock.writeLock();

    public ClientHandler(Command cmd) {
        this.cmd = cmd;
    }

    public String getSentMsg() { return sentMsg; }

    void clearFile() {
        try {
            new FileWriter(dbFile, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFromDB(String key) {
        File file = new File(dbFile);
        readLock.lock();
        try (Scanner f = new Scanner(file)) {
            while (f.hasNext()) {
                String line = f.nextLine();
                if (line.equals("{}")) {
                    clearFile(); continue;
                }
                DBEntry data = gson.fromJson(line, DBEntry.class);
                if (data.getKey().equals(key)) {
                    readLock.unlock();
                    return data.getValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        readLock.unlock();
        return "ERROR";
    }

    void writeToDB(String key, String value) {
        if (!readFromDB(key).equals("ERROR")) {
            deleteFromDB(key);
        }
        writeLock.lock();
        try (FileWriter writer = new FileWriter(dbFile, true)) {
            writer.write("{key:\"" + key + "\",value:\"" + value + "\"}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLock.unlock();
    }

    void deleteFromDB(String key) {
        File DBFile = new File(dbFile);
        ArrayList<String> lines = new ArrayList<>();
        readLock.lock();
        try (Scanner f = new Scanner(DBFile)) {
            while (f.hasNext()) {
                String line = f.nextLine();
                DBEntry data = gson.fromJson(line, DBEntry.class);
                if (data.getKey().equals(key)) break;
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        readLock.unlock(); writeLock.lock();
        try (FileWriter writer = new FileWriter(dbFile)) {
            for (String line: lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLock.unlock();
    }

    String setDB(Command command) {
        writeToDB(command.getKey(), command.getValue());
        return "OK";
    }

    String getDB(Command command) {
        String DBResp = readFromDB(command.getKey());
        if (DBResp.equals("ERROR")) return "ERROR";
        return DBResp;
    }


    String deleteDB(Command command) {
        if (readFromDB(command.getKey()).equals("ERROR")) {
            return "ERROR";
        }
        deleteFromDB(command.getKey());
        return "OK";
    }

    @Override
    public String call() throws Exception {
        HashMap<String, String> resp = new HashMap<>();
        switch (cmd.getType()) {
            case "set":
                resp.put("response", setDB(cmd));
                break;
            case "get":
                if (getDB(cmd).equals("ERROR")) {
                    resp.put("response", "ERROR"); resp.put("reason", "No such key");
                } else {
                    resp.put("response", "OK"); resp.put("value", getDB(cmd));
                }
                break;
            case "delete":
                if (deleteDB(cmd).equals("ERROR")) {
                    resp.put("response", "ERROR"); resp.put("reason", "No such key");
                } else resp.put("response", "OK");
                break;
            default:
                resp.put("respone", "Invalid command");
        }
        return gson.toJson(resp);
    }
}

public class Main {
    static Gson gson = new Gson();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String address = "127.0.0.1";
        int port = 33110;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address))) {
            System.out.println("Server started!");
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF();
                    Command cmd = gson.fromJson(msg, Command.class);
                    if (cmd.getType().equalsIgnoreCase("exit")) break;
                    ClientHandler clientHandler = new ClientHandler(cmd);
                    Future<String> future = executor.submit(clientHandler);
                    String sentMsg = future.get();
                    output.writeUTF(sentMsg);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
