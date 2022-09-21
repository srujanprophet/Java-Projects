// 1. 100-cell database

package server;

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
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            String[] command = input.split(" ");
            switch (command[0]) {
                case "set": setDB(command); break;
                case "get": getDB(command); break;
                case "delete": deleteDB(command); break;
                default: System.out.println("Invalid command");
            }
        }
    }
}
