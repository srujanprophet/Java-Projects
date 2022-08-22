// 1. A Needle in the Hay

package phonebook;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File search_file = new File("C:/Users/dodge/Downloads/find.txt");
        File directory_file = new File("C:/Users/dodge/Downloads/directory.txt");
        int total = 0, found = 0;
        ArrayList<String> contacts = new ArrayList<>();
        try (Scanner sc = new Scanner(search_file)) {
            while (sc.hasNext()) {
                contacts.add(sc.nextLine());
                total++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Search file not found");
        }
        Instant start = Instant.now();
        try (Scanner sc = new Scanner(directory_file)) {
            System.out.println("Start searching...");
            while (sc.hasNext()) {
                String[] details = sc.nextLine().split(" ");
                String name = (details.length == 3) ? (details[1] + " " + details[2]) : details[1];
                for (String search_name: contacts) {
                    if (search_name.equals(name)) found++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory file not found");
        }
        Instant stop = Instant.now();
        Duration d = Duration.between(start, stop);
        long minutes = d.toMinutesPart();
        long seconds = d.toSecondsPart();
        long millis = d.toMillisPart();
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n",
                found, total, minutes, seconds, millis);
    }
}
