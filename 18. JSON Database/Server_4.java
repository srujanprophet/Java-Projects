package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
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

public class Main {

    static HashMap<String, String> jsonDB = new HashMap<>();
    static Gson gson = new Gson();

    static boolean isValid(int index) { return (index > 0 && index < 1001); }

    static String setDB(Command command) {
        jsonDB.put(command.getKey(), command.getValue());
        return "OK";
    }

    static String getDB(Command command) {
        if (jsonDB.get(command.getKey()) != null) return jsonDB.get(command.getKey());
        return "ERROR";
    }

    static String deleteDB(Command command) {
        if (jsonDB.get(command.getKey()) != null) {
            jsonDB.remove(command.getKey()); return "OK";
        }
        return "ERROR";
    }


    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
        try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address))) {
            System.out.println("Server started!");
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF();
                    HashMap<String, String> resp = new HashMap<>();
                    Command cmd = gson.fromJson(msg, Command.class);
                    String sentMsg;
                    boolean flag = false;
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
                        case "exit":
                            resp.put("response", "OK");
                            flag = true;
                            break;
                        default:
                            resp.put("respone", "Invalid command");
                    }
                    sentMsg = gson.toJson(resp);
                    output.writeUTF(sentMsg);
                    if (flag) break;
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
