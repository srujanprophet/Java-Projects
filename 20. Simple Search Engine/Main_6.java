// 6. Search Strategies

package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<String> data = new ArrayList<>();
    static HashMap<String,HashSet<Integer>> invIndex = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    static HashSet<Integer> findAnyPerson(List<String> search) {
        HashSet<Integer> found = new HashSet<>();
        for (String word: search) {
            if (invIndex.get(word) == null) continue;
            found.addAll(invIndex.get(word));
        }
        return found;
    }

    static HashSet<Integer> findAllPerson(List<String> search) {
        HashSet<Integer> found = new HashSet<>();
        for (String word: search) {
            if (invIndex.get(word) == null) continue;
            if (found.isEmpty()) found = invIndex.get(word);
            else found.retainAll(invIndex.get(word));
        }
        return found;
    }

    static HashSet<Integer> findNoPerson(List<String> search) {
        HashSet<Integer> found = new HashSet<>();
        HashSet<Integer> negatives = new HashSet<>();
        for (String word: search) {
            if (invIndex.get(word) == null) continue;
            negatives.addAll(invIndex.get(word));
        }
        for (int i = 0; i < data.size(); i++) found.add(i);
        found.removeAll(negatives);
        return found;
    }

    static void findPerson() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        String strat = sc.nextLine().toUpperCase();

        System.out.println("\nEnter a name or email to search all suitable people.");
        String words = sc.nextLine().toUpperCase();
        List<String> search = Arrays.asList(words.split(" "));

        HashSet<Integer> found = new HashSet<>();
        switch (strat) {
            case "ANY": found = findAnyPerson(search); break;
            case "ALL" : found = findAllPerson(search); break;
            case "NONE" : found = findNoPerson(search); break;
            default : System.out.println("Invalid search strategy");
        }

        if (found.isEmpty()) System.out.println("No matching people found.");
        else {
            System.out.printf("%d persons found:\n", found.size());
            found.forEach(x -> System.out.println(data.get(x)));
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

    static void addToInvertedIndex(int line_num, String word) {
        HashSet<Integer> list = new HashSet<>();
        if (invIndex.containsKey(word)) {
            list = invIndex.get(word);
            list.add(line_num);
        } else {
            list.add(line_num);
        }
        invIndex.put(word, list);
    }

    static void readData(String filename) {
        File file = new File(filename);
        int line_num = 0;
        try (Scanner f = new Scanner(file)) {
            while (f.hasNext()) {
                String line = f.nextLine();
                List<String> words = Arrays.asList(line.split(" "));
                for (String word: words) {
                    addToInvertedIndex(line_num, word.toUpperCase());
                }
                data.add(line);
                line_num++;
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

