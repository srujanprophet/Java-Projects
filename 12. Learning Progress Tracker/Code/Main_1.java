// 1. No Empty Lines Here

package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye!"); break;
            } else if (input.trim().length() == 0) System.out.println("No input.");
            else System.out.println("Error: unknown command!");
        }
    }
}
