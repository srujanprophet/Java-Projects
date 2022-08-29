// 2. Jumping Bubbles

package phonebook;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    static File search_file = new File("C:/Users/dodge/Downloads/find.txt");
    static File directory_file = new File("C:/Users/dodge/Downloads/directory.txt");
    static ArrayList<String> persons = new ArrayList<>();
    static ArrayList<String> contacts = new ArrayList<>();
    static int total = 0;
    static int found = 0;

    static void jumpSearch(String contact_name) {
        if (persons.isEmpty()) return;

        int cur = 0, prev = 0, last = persons.size() - 1;
        int step = (int) Math.floor(Math.sqrt(persons.size())) + 1;

        while (persons.get(cur).compareTo(contact_name) < 0) {
            if (cur == last) return;
            prev = cur;
            cur = Math.min(cur + step, last);
        }
        while (persons.get(cur).compareTo(contact_name) > 0) {
            cur = cur - 1;
            if (cur < prev) return;
        }
    }

    static Duration jumpSearchContacts() {
        Instant start = Instant.now();
        for (String contact: contacts) {
            jumpSearch(contact);
        }
        Instant stop = Instant.now();
        Duration d = Duration.between(start, stop);
        return d;
    }

    static void bubble_sort(Duration d_search) {
        Instant start = Instant.now();
        Duration d_bubble = Duration.ZERO;
        boolean time_exceeded = false;
        for (int i = 0; i < persons.size() - 1 ; i++) {
            for (int j = 1; j < persons.size(); j++) {
                if (persons.get(i).compareTo(persons.get(j)) > 0) {
                    String temp = persons.get(j);
                    persons.set(j, persons.get(i));
                    persons.set(i, temp);
                }
            }
            Instant stop = Instant.now();
            d_bubble = Duration.between(start, stop);
            if (d_bubble.compareTo(d_search.multipliedBy(10)) > 0) {
                time_exceeded = true;
                d_search =  linear_search();
                break;
            }
        }
        if (time_exceeded) {
            Duration d_new = d_bubble.plus(d_search);
            System.out.printf("%d min. %d sec. %d ms.\n", d_new.toMinutesPart(), d_new.toSecondsPart(),
                    d_new.toMillisPart());
            System.out.printf("Sorting time: %d min. %d sec %d ms. - STOPPED, moved to linear search\n",
                    d_bubble.toMinutesPart(), d_bubble.toSecondsPart(), d_bubble.toMillisPart());
        } else {
            d_search = jumpSearchContacts();
            Duration d_new = d_bubble.plus(d_search);
            System.out.printf("%d min. %d sec. %d ms.\n", d_new.toMinutesPart(), d_new.toSecondsPart(),
                    d_new.toMillisPart());
            System.out.printf("Sorting time: %d min. %d sec %d ms.\n",
                    d_bubble.toMinutesPart(), d_bubble.toSecondsPart(), d_bubble.toMillisPart());
        }
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", d_search.toMinutesPart(),
                d_search.toSecondsPart(), d_search.toMillisPart());
    }

    static Duration linear_search() {
        Instant start_linear = Instant.now();
        try (Scanner sc = new Scanner(directory_file)) {
            while (sc.hasNext()) {
                String[] details = sc.nextLine().split(" ");
                String name = (details.length == 3) ? (details[1] + " " + details[2]) : details[1];
                persons.add(name);
                for (String search_name: contacts) {
                    if (search_name.equals(name)) found++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory file not found");
        }
        Instant stop_linear = Instant.now();
        Duration d_linear = Duration.between(start_linear, stop_linear);
        return d_linear;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(search_file)) {
            while (sc.hasNext()) {
                contacts.add(sc.nextLine());
                total++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Search file not found");
        }

        System.out.println("Start searching...");
        Duration d_linear = linear_search();
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n",
                found, total, d_linear.toMinutesPart(), d_linear.toSecondsPart(), d_linear.toMillisPart());

        System.out.println("\nStart searching (bubble sort + jump search)...");
        System.out.printf("Found %d / %d entries. Time taken: ", found, total);
        bubble_sort(d_linear);
    }
}
