package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Main {

    static HashMap<Integer, String> jsonDB = new HashMap<>();

    static boolean isValid(int index) { return (index > 0 && index < 1001); }

    static String setDB(String[] command) {
        StringBuilder sb = new StringBuilder();
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx)) {
            for (int i = 2; i < command.length; i++) sb.append(command[i]).append(" ");
            sb.deleteCharAt(sb.length() - 1);
            jsonDB.put(idx, sb.toString());
            return "OK";
        } else {
            return "ERROR";
        }
    }

    static String getDB(String[] command) {
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx) && (jsonDB.get(idx) != null)) {
            return jsonDB.get(idx);
        }
        return "ERROR";
    }

    static String deleteDB(String[] command) {
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx)) {
            if (jsonDB.get(idx) != null) jsonDB.remove(idx);
            return "OK";
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
                    String[] command = msg.split(" ");
                    String sentMsg;
                    boolean flag = false;
                    switch (command[0]) {
                        case "set":
                            sentMsg = setDB(command);
                            break;
                        case "get":
                            sentMsg = getDB(command);
                            break;
                        case "delete":
                            sentMsg = deleteDB(command);
                            break;
                        case "exit":
                            sentMsg = "OK"; flag = true;
                            break;
                        default:
                            sentMsg = "Invalid command";
                    }
                    output.writeUTF(sentMsg);
                    if (flag) break;
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
