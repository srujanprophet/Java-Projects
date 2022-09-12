package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


class Args {
    @Parameter(names = {"-t"}, description = "Type of request")
    String type;

    @Parameter(names = {"-k"}, description = "Key to save")
    String key;

    @Parameter(names = {"-v"}, description = "Value to save")
    String value;
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Gson gson = new Gson();

    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
        HashMap<String, String> cmd = new HashMap<>();
        System.out.println("Client started!");
        Args command = new Args();
        JCommander.newBuilder()
                .addObject(command)
                .build()
                .parse(args);

        try (
            Socket socket = new Socket(Inet4Address.getByName(address), port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            cmd.put("type", command.type); cmd.put("key", command.key);
            if (command.value != null) cmd.put("value", command.value);
            String msg = gson.toJson(cmd);
            output.writeUTF(msg);
            System.out.println("Sent: " + msg);
            String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
