package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;


class Args {
    @Parameter(names = {"-t"}, description = "Type of request")
    String type;

    @Parameter(names = {"-i"}, description = "Index of cell")
    int idx;

    @Parameter(names = {"-m"}, description = "Value to save")
    String message;
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
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
            StringBuilder msg = new StringBuilder(command.type + " " + command.idx);
            if (command.type.equalsIgnoreCase("set")) {
                msg.append(" ").append(command.message);
            }
            output.writeUTF(msg.toString());
            System.out.println("Sent: " + msg);
            String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
