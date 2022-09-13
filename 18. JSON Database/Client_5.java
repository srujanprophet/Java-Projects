package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;



class Args {
    @Parameter(names = {"-t"}, description = "Type of request")
    String type;

    @Parameter(names = {"-k"}, description = "Key to save")
    String key;

    @Parameter(names = {"-v"}, description = "Value to save")
    String value;

    @Parameter(names = {"-in"}, description = "Input filename")
    String inputFile = "";
}

public class Main {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
        String msg = "";
        HashMap<String, String> cmd = new HashMap<>();
        System.out.println("Client started!");
        Args command = new Args();
        JCommander.newBuilder()
                .addObject(command)
                .build()
                .parse(args);

        if (command.inputFile.length() > 0) {
            try {
                String fileName = "src/client/data/" + command.inputFile;
                msg = new String(Files.readAllBytes(Paths.get(fileName)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (
            Socket socket = new Socket(Inet4Address.getByName(address), port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            if (msg.length() == 0) {
                cmd.put("type", command.type);
                cmd.put("key", command.key);
                if (command.value != null) cmd.put("value", command.value);
                msg = gson.toJson(cmd);
            }
            output.writeUTF(msg);
            System.out.println("Sent: " + msg);
            String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
