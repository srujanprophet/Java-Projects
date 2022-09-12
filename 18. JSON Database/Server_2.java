package server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 33110;
        try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address))) {
            System.out.println("Server started!");
            try (
                Socket socket = server.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String msg = input.readUTF();
                System.out.println("Received: " + msg);
                String[] number = msg.split(" ");
                String sentMsg = "A record # " + number[number.length - 1] + " was sent!";
                output.writeUTF(sentMsg);
                System.out.println("Sent: " + sentMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
