// 3. User Menu

package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<String> data = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static void findPerson() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String search = sc.nextLine().toUpperCase();
        List<String> found = data.stream().filter(s -> s.toUpperCase().contains(search)).collect(Collectors.toList());
        if (found.isEmpty()) System.out.println("No matching people found.");
        else {
            found.forEach(System.out::println);
        }
    }

    static void printData() {
        System.out.println("\n=== List of people ===");
        data.forEach(System.out::println);
    }

    static void menu() {
        while (true) {
            System.out.println("\n=== Menu ===\n1. Find a person\n2. Print all people\n0.Exit");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;
            if (choice == 1) findPerson();
            else if (choice == 2) printData();
            else System.out.println("\nIncorrect option! Try again.");
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter the number of people:");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < n; i++) {
            data.add(sc.nextLine());
        }
        menu();
        System.out.println("\nBye!");
    }
}

