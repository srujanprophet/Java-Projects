// 4. Everything Counts

package sorting;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Long> getLongs() {
        ArrayList<Long> nums = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            nums.add(number);
        }
        return nums;
    }

    static ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();
        System.out.print(" ");

        while (scanner.hasNext()) {
            System.out.print(" ");
            String input = scanner.nextLine();
            lines.add(input);
        }
        return lines;
    }

    static ArrayList<String> getWords() {
        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        return words;
    }

    static void sortLongByCount() {

        ArrayList<Long> nums = getLongs();
        TreeMap<Long, Integer> counts = new TreeMap<>();
        int total = nums.size();

        for (Long x: nums) {
            int ctr = 0;
            for (Long n: nums) {
                if (Objects.equals(n, x)) ctr++;
            }
            counts.put(x, ctr);
        }

        System.out.println("Total numbers: " + total + ".");

        List <Map.Entry<Long, Integer>> num_list = new LinkedList<>(counts.entrySet());
        num_list.sort(Map.Entry.comparingByValue());

        for (var entry: num_list) {
            System.out.printf("%d: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total));
        }
    }

    static void sortLong() {
        ArrayList<Long> nums = getLongs();
        Collections.sort(nums);
        System.out.println("Total numbers: " + nums.size() + ".");
        System.out.print("Sorted data: ");
        nums.forEach((n) -> System.out.print(n + " "));
    }

    static void sortLineByCount() {
        ArrayList<String> lines = getLines();
        TreeMap<String, Integer> counts = new TreeMap<>();
        int total = lines.size();

        for (String line: lines) {
            int ctr = 0;
            for (String n: lines) {
                if (n.equals(line)) ctr++;
            }
            counts.put(line, ctr);
        }

        System.out.println("Total lines: " + total + ".");

        List <Map.Entry<String, Integer>> line_list = new LinkedList<>(counts.entrySet());
        line_list.sort(Map.Entry.comparingByValue());

        for (var entry: line_list) {
            System.out.printf("%s: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total));
        }
    }

    static void sortLine() {
        ArrayList<String> lines = getLines();
        Collections.sort(lines);
        System.out.println("Total lines: " + lines.size() + ".");
        System.out.println("Sorted data: ");
        lines.forEach(System.out::println);
    }

    static void sortWordByCount() {
        ArrayList<String> words = getWords();
        TreeMap<String, Integer> counts = new TreeMap<>();
        int total = words.size();

        for (String word: words) {
            int ctr = 0;
            for (String n: words) {
                if (n.equals(word)) ctr++;
            }
            counts.put(word, ctr);
        }

        System.out.println("Total words: " + total + ".");

        List <Map.Entry<String, Integer>> word_list = new LinkedList<>(counts.entrySet());
        word_list.sort(Map.Entry.comparingByValue());

        for (var entry: word_list) {
            System.out.printf("%s: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total));
        }
    }

    static void sortWord() {
        ArrayList<String> words = getWords();
        Collections.sort(words);
        System.out.println("Total words: " + words.size() + ".");
        System.out.print("Sorted data: ");
        words.forEach((word) -> System.out.print(word + " "));
    }

    static void sortByCount(String dataType) {
        if (dataType.equals("long")) sortLongByCount();
        else if (dataType.equals("word")) sortWordByCount();
        else sortLineByCount();
    }

    static void naturalSort(String dataType) {
        if (dataType.equals("long")) sortLong();
        else if (dataType.equals("word")) sortWord();
        else sortLine();
    }

    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";
        ArrayList<String> args_list = new ArrayList<>(Arrays.asList(args));
        int sort_idx = args_list.indexOf("-sortingType");
        int data_idx = args_list.indexOf("-dataType");

        if (sort_idx != -1) sortingType = args_list.get(sort_idx + 1);
        if (data_idx != -1) dataType = args_list.get(data_idx + 1);

        if (sortingType.equals("byCount")) sortByCount(dataType);
        else naturalSort(dataType);
    }
}
