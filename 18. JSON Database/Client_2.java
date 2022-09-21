// 1. 100-cell database

package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, String> jsonDB = new HashMap<>();

    static boolean isValid(int index) { return (index > 0 && index < 101); }

    static void setDB(String[] command) {
        StringBuilder sb = new StringBuilder();
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx)) {
            for (int i = 2; i < command.length; i++) sb.append(command[i]).append(" ");
            sb.deleteCharAt(sb.length() - 1);
            jsonDB.put(idx, sb.toString());
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    static void getDB(String[] command) {
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx) && (jsonDB.get(idx) != null)) System.out.println(jsonDB.get(idx));
        else System.out.println("ERROR");
    }

    static void deleteDB(String[] command) {
        int idx = Integer.parseInt(command[1]);
        if (isValid(idx)) {
             if (jsonDB.get(idx) != null) jsonDB.remove(idx);
             System.out.println("OK");
        } else System.out.println("ERROR");
    }


    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
        try (
            Socket socket = new Socket(Inet4Address.getByName(address), port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            String msg = "Give me a record # 13"; output.writeUTF(msg);
            System.out.println("Sent: " + msg); String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
