package phonebook;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
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
        return Duration.between(start, stop);
    }

    static void bubble_sort(Duration d_search) {
        Instant start = Instant.now();
        Duration d_bubble = Duration.ZERO;
        ArrayList<String> persons_copy = new ArrayList<>(persons);
        boolean time_exceeded = false;
        for (int i = 0; i < persons.size() - 1 ; i++) {
            for (int j = 1; j < persons.size(); j++) {
                if (persons_copy.get(i).compareTo(persons_copy.get(j)) > 0) {
                    String temp = persons_copy.get(j);
                    persons_copy.set(j, persons_copy.get(i));
                    persons_copy.set(i, temp);
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
        return Duration.between(start_linear, stop_linear);
    }

    static int partition(ArrayList<String> arr, int low, int high) {
        String pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;
                String temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        String temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
        return (i+1);
    }

    static void quick_sort(ArrayList<String> persons, int low, int high) {
        if (low < high) {
            int pi = partition(persons, low, high);
            quick_sort(persons, low, pi - 1);
            quick_sort(persons, pi + 1, high);
        }
    }

    static void binary_search(String val) {
        int low = 0, high = persons.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String contact = persons.get(mid);
            if (contact.compareTo(val) == 0) return;
            else if (contact.compareTo(val) > 0) low = mid + 1;
            else high = mid - 1;
        }
    }

    static void binarySearchContacts() {
        for (String contact: contacts) {
            binary_search(contact);
        }
    }

    static Duration linear_search_duration() {
        System.out.println("Start searching (linear search)...");
        Duration d_linear = linear_search();
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n",
                found, total, d_linear.toMinutesPart(), d_linear.toSecondsPart(), d_linear.toMillisPart());
        return d_linear;
    }

    static void bubble_sort_duration(Duration d_linear) {
        System.out.println("\nStart searching (bubble sort + jump search)...");
        System.out.printf("Found %d / %d entries. Time taken: ", found, total);
        bubble_sort(d_linear);
    }

    static void quick_sort_duration() {
        Instant start_quick_sort = Instant.now();
        System.out.println("\nStart searching (quick sort + binary search)...");
        System.out.printf("Found 500 / 500 entries. Time taken: ", found, total);
        quick_sort(persons, 0, persons.size() - 1);
        Instant stop_quick_sort = Instant.now();
        Duration d_quick_sort = Duration.between(start_quick_sort, stop_quick_sort);
        Instant start_binary_search = Instant.now();
        binarySearchContacts();
        Instant stop_binary_search = Instant.now();
        Duration d_binary_search = Duration.between(start_binary_search, stop_binary_search);
        Duration total = d_quick_sort.plus(d_binary_search);
        System.out.printf("%d min. %d sec. %d ms.\n",
                total.toMinutesPart(), total.toSecondsPart(), total.toMillisPart());
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", d_quick_sort.toMinutesPart(),
                d_quick_sort.toSecondsPart(), d_quick_sort.toMillisPart());
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", d_binary_search.toMinutesPart(),
                d_binary_search.toSecondsPart(), d_binary_search.toMillisPart());
    }

    static void hash_table_duration() {
        int hash_found = 0, hash_total = 0;
        System.out.println("\nStart searching (hash table)...");
        HashMap<String, String> directory = new HashMap<>();
        Instant start_hash_create = Instant.now();
        try (Scanner sc = new Scanner(directory_file)) {
            while (sc.hasNext()) {
                String[] details = sc.nextLine().split(" ");
                String name = (details.length == 3) ? (details[1] + " " + details[2]) : details[1];
                directory.put(name, details[0]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory file not found");
        }
        Instant stop_hash_create = Instant.now();
        Duration hash_create = Duration.between(start_hash_create, stop_hash_create);
        Instant start_hash_search = Instant.now();
        for (String s: contacts) {
            if (directory.containsKey(s)) hash_found++;
        }
        Instant stop_hash_search = Instant.now();
        Duration hash_search = Duration.between(start_hash_search, stop_hash_search);
        Duration total_hash = hash_search.plus(hash_create);
        System.out.printf("Found %d / %d entries. Time taken : %d min. %d sec. %d ms.\n", hash_found, total,
                total_hash.toMinutesPart(), total_hash.toSecondsPart(), total_hash.toMillisPart());
        System.out.printf("Creating time: %d min. %d sec. %d ms.\n", hash_create.toMinutesPart(),
                hash_create.toSecondsPart(), hash_create.toMillisPart());
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", hash_search.toMinutesPart(),
                hash_search.toSecondsPart(), hash_search.toMillisPart());
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

        Duration d_linear = linear_search_duration();

        bubble_sort_duration(d_linear);

        quick_sort_duration();

        hash_table_duration();
    }
}
