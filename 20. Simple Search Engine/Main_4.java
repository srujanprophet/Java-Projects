// 4. X-files

package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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

    static void readData(String filename) {
        File file = new File(filename);
        try (Scanner f = new Scanner(file)) {
            while (f.hasNext()) {
                data.add(f.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> cmd = Arrays.asList(args);
        int data = cmd.indexOf("--data") + 1;
        if (data != 0) readData(cmd.get(data));
        menu();
        System.out.println("\nBye!");
    }
}
