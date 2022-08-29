// 4. Odd Mirrors

package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static void moo() {
//        System.out.printf("%s_______ \n", " ".repeat(20));
//        System.out.printf("%s< hello >\n", " ".repeat(19));
//        System.out.printf("%s%s \n"," ".repeat(20), "-".repeat(7));
        System.out.printf("%s^__^\n", " ".repeat(12));
        System.out.printf("    %s/(oo)\n", "_".repeat(7));
        System.out.printf("/\\/(%s/(__)\n", " ".repeat(7));
        System.out.print("   | w----||    \n");
        System.out.printf("   ||%s||    \n"," ".repeat(5));
    }


        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the file path:");
        String file_path = sc.nextLine();

        File file = new File(file_path);
        ArrayList<String> lines = new ArrayList<>();
        int max_line_length = -1;

        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                lines.add(fs.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        for (String line : lines) {
            if (line.length() > max_line_length) max_line_length = line.length();
        }
        for (String line: lines) {
            String extra_spaces = " ".repeat(max_line_length - line.length());
            System.out.printf("%s%s | %s%s\n", line, extra_spaces, line, extra_spaces);
        }
    }
}
