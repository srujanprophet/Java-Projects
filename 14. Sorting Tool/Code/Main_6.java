// 6. X-Files

package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Long> getLongs(String inFilePath) {
        ArrayList<Long> nums = new ArrayList<>();

        if (inFilePath.length() == 0) {
            while (scanner.hasNext()) {
                String number = scanner.next();
                try { nums.add(Long.parseLong(number)); }
                catch (NumberFormatException e) {
                    System.out.printf("%s is not a long. It will be skipped.\n", number);
                }
            }
        } else {
            File file = new File(inFilePath);
            try (Scanner f = new Scanner(file)) {
                while (f.hasNext()) {
                    String number = f.next();
                    try { nums.add(Long.parseLong(number)); }
                    catch (NumberFormatException e) {
                        System.out.printf("%s is not a long. It will be skipped.\n", number);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
        return nums;
    }

    static ArrayList<String> getLines(String inFilePath) {
        ArrayList<String> lines = new ArrayList<>();

        if (inFilePath.length() == 0) {
            System.out.print(" ");
            while (scanner.hasNext()) {
                System.out.print(" ");
                String input = scanner.nextLine();
                lines.add(input);
            }
        } else {
            File file = new File(inFilePath);
            try (Scanner f = new Scanner(file)) {
                while (f.hasNext()) {
                    String input = f.nextLine();
                    lines.add(input);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
        return lines;
    }

    static ArrayList<String> getWords(String inFilePath) {
        ArrayList<String> words = new ArrayList<>();

        if (inFilePath.length() == 0) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } else {
            File file = new File(inFilePath);
            try (Scanner f = new Scanner(file)) {
                while (f.hasNext()) {
                    words.add(f.next());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
        return words;
    }

    static void sortLongByCount(String inFilePath, String outFilePath) {
        ArrayList<Long> nums = getLongs(inFilePath);
        ArrayList<String> outputLines = new ArrayList<>();
        TreeMap<Long, Integer> counts = new TreeMap<>();
        int total = nums.size();

        for (Long x: nums) {
            int ctr = 0;
            for (Long n: nums) {
                if (Objects.equals(n, x)) ctr++;
            }
            counts.put(x, ctr);
        }

        outputLines.add(String.format("Total numbers: " + total + ".\n"));

        List <Map.Entry<Long, Integer>> num_list = new LinkedList<>(counts.entrySet());
        num_list.sort(Map.Entry.comparingByValue());

        for (var entry: num_list) {
            outputLines.add(String.format("%d: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total)));
        }

        if (outFilePath.length() == 0) {
            outputLines.forEach(System.out::print);
        } else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)){
                for (String outputLine: outputLines) {
                    writer.write(outputLine);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void sortLong(String inFilePath, String outFilePath) {
        ArrayList<Long> nums = getLongs(inFilePath);
        Collections.sort(nums);
        if (outFilePath.length() == 0) {
            System.out.print("Total numbers: " + nums.size() + ".\nSorted data: ");
            nums.forEach((n) -> System.out.print(n + " "));
        }
        else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(String.format("Total numbers: " + nums.size() + ".\nSorted data: "));
                for (Long n : nums) writer.write(String.format(n + " "));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void sortLineByCount(String inFilePath, String outFilePath) {
        ArrayList<String> lines = getLines(inFilePath);
        TreeMap<String, Integer> counts = new TreeMap<>();
        ArrayList<String> outputLines = new ArrayList<>();
        int total = lines.size();

        for (String line: lines) {
            int ctr = 0;
            for (String n: lines) {
                if (n.equals(line)) ctr++;
            }
            counts.put(line, ctr);
        }

        outputLines.add(String.format("Total lines: " + total + ".\n"));

        List <Map.Entry<String, Integer>> line_list = new LinkedList<>(counts.entrySet());
        line_list.sort(Map.Entry.comparingByValue());

        for (var entry: line_list) {
            outputLines.add(String.format("%s: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total)));
        }

        if (outFilePath.length() == 0) {
            outputLines.forEach(System.out::print);
        } else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                for (String outputLine : outputLines) writer.write(outputLine);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void sortLine(String inFilePath, String outFilePath) {
        ArrayList<String> lines = getLines(inFilePath);
        Collections.sort(lines);

        if (outFilePath.length() == 0) {
            System.out.print("Total lines: " + lines.size() + ".\nSorted data: \n");
            lines.forEach(System.out::println);
        } else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(String.format("Total lines: " + lines.size() + ".\nSorted data: \n"));
                for (String outputLine : lines) writer.write(outputLine + "\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void sortWordByCount(String inFilePath, String outFilePath) {
        ArrayList<String> words = getWords(inFilePath);
        TreeMap<String, Integer> counts = new TreeMap<>();
        ArrayList<String> outputLines = new ArrayList<>();
        int total = words.size();

        for (String word: words) {
            int ctr = 0;
            for (String n: words) {
                if (n.equals(word)) ctr++;
            }
            counts.put(word, ctr);
        }

        outputLines.add(String.format("Total words: " + total + ".\n"));
        List <Map.Entry<String, Integer>> word_list = new LinkedList<>(counts.entrySet());
        word_list.sort(Map.Entry.comparingByValue());

        for (var entry: word_list) {
            outputLines.add(String.format("%s: %d time(s), %d%%\n", entry.getKey(), entry.getValue(),
                    Math.round((entry.getValue() * 100.0) / total)));
        }

        if (outFilePath.length() == 0) {
            outputLines.forEach(System.out::print);
        } else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                for (String outputLine : outputLines) writer.write(outputLine);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    static void sortWord(String inFilePath, String outFilePath) {
        ArrayList<String> words = getWords(inFilePath);
        Collections.sort(words);

        if (outFilePath.length() == 0) {
            System.out.print("Total words: " + words.size() + ".\nSorted data: ");
            words.forEach((word) -> System.out.print(word + " "));
        }
        else {
            File file = new File(outFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(String.format("Total words: " + words.size() + ".\nSorted data: "));
                for (String word : words) writer.write(word + " ");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void sortByCount(String dataType, String inFilePath, String outFilePath) {
        if (dataType.equals("long")) sortLongByCount(inFilePath, outFilePath);
        else if (dataType.equals("word")) sortWordByCount(inFilePath, outFilePath);
        else sortLineByCount(inFilePath, outFilePath);
    }

    static void naturalSort(String dataType, String inFilePath, String outFilePath) {
        if (dataType.equals("long")) sortLong(inFilePath, outFilePath);
        else if (dataType.equals("word")) sortWord(inFilePath, outFilePath);
        else sortLine(inFilePath, outFilePath);
    }

    public static void main(final String[] args) {
        String dataType = "word"; String sortingType = "natural";
        String inputFilePath = ""; String outputFilePath = "";
        ArrayList<String> args_list = new ArrayList<>(Arrays.asList(args));
        int sort_idx = args_list.indexOf("-sortingType");
        int data_idx = args_list.indexOf("-dataType");
        int input_file_idx = args_list.indexOf("-inputFile");
        int output_file_idx = args_list.indexOf("-outputFile");

        try { if (sort_idx != -1) sortingType = args_list.get(sort_idx + 1); }
        catch (IndexOutOfBoundsException e) { System.out.println("No sorting type defined!"); }
        try { if (data_idx != -1) dataType = args_list.get(data_idx + 1); }
        catch (IndexOutOfBoundsException e) { System.out.println("No data type defined!"); }
        if (input_file_idx != -1) inputFilePath = args_list.get(input_file_idx + 1);
        if (output_file_idx != -1) outputFilePath = args_list.get(output_file_idx + 1);

        for (String arg: args_list) {
            if (arg.charAt(0) == '-') {
                if (!(arg.equals("-sortingType") || arg.equals("-dataType") ||
                        arg.equals("-inputFile") || arg.equals("-outputFile"))) {
                    System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", arg);
                }
            }
        }

        if (sortingType.equals("byCount")) sortByCount(dataType, inputFilePath, outputFilePath);
        else naturalSort(dataType, inputFilePath, outputFilePath);
    }
}
