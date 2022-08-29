// 3. Sorting it Out

package sorting;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static void longInput() {
        ArrayList<Long> nums = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            nums.add(number);
        }

        long max_num = Collections.max(nums);
        int max_count = 0;
        for (Long x : nums) {
            if (x == max_num) max_count++;
        }

        System.out.println("Total numbers: " + nums.size() + ".");
        System.out.printf("The greatest number: %d (%d time(s), %d%%).\n", max_num,
                max_count, (max_count * 100) / nums.size());
    }

    static void lineInput() {
        ArrayList<String> lines = new ArrayList<>();

        System.out.print(" ");

        while (scanner.hasNext()) {
            System.out.print(" ");
            String input = scanner.nextLine();
            lines.add(input);
        }

        int total = lines.size();
        String longest_line = lines.get(0);
        for (String line: lines) {
            if (line.length() > longest_line.length()) longest_line = line;
        }
        int longest_count = 0;
        for (String line: lines) {
            if (line.equals(longest_line)) longest_count++;
        }

        System.out.printf("Total lines: %d.\nThe longest line:\n%s\n(%d time(s), %d%%).\n",
                total, longest_line, longest_count, (longest_count * 100) / total);
    }

    static void wordInput() {
        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        int total = words.size();
        String longest_word = words.get(0);
        for (String word: words) {
            if (word.length() > longest_word.length()) longest_word = word;
        }
        int longest_count = 0;
        for (String word: words) {
            if (word.equals(longest_word)) longest_count++;
        }

        System.out.printf("Total words: %d.\nThe longest word: %s (%d time(s), %d%%).\n",
                total, longest_word, longest_count, (longest_count * 100) / total);

    }

    static void sortIntegers() {
        ArrayList<Integer> nums = new ArrayList<>();
        while (scanner.hasNext()) {
            nums.add(scanner.nextInt());
        }
        Collections.sort(nums);
        System.out.println("Total numbers: " + nums.size() + ".");
        System.out.print("Sorted data: ");
        nums.forEach(n -> System.out.print(n + " "));
    }

    public static void main(final String[] args) {
        String dataType = "word";
        ArrayList<String> args_list = new ArrayList<>(Arrays.asList(args));
        if (args.length == 2) dataType = args[1];
        if (args_list.contains("-sortIntegers")) sortIntegers();
        else if (dataType.equals("long")) longInput();
        else if (dataType.equals("line")) lineInput();
        else wordInput();
    }
}
