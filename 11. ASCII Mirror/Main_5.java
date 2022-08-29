// 5. Getting It Straight

package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static String replaceMirror(String line) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') temp.append(">");
            else if (line.charAt(i) == '>') temp.append("<");
            else if (line.charAt(i) == '[') temp.append("]");
            else if (line.charAt(i) == ']') temp.append("[");
            else if (line.charAt(i) == '{') temp.append("}");
            else if (line.charAt(i) == '}') temp.append("{");
            else if (line.charAt(i) == '(') temp.append(")");
            else if (line.charAt(i) == ')') temp.append("(");
            else if (line.charAt(i) == '/') temp.append("\\");
            else if (line.charAt(i) == '\\') temp.append("/");
            else temp.append(line.charAt(i));
        }
        return temp.toString();
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
            StringBuilder mirror = new StringBuilder(line + extra_spaces);
            mirror.reverse();
            String reversedLine = replaceMirror(mirror.toString());
            System.out.printf("%s%s | %s\n", line, extra_spaces, reversedLine);
        }
    }
}
