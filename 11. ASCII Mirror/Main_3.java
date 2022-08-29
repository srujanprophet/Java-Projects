// 3. New Friends

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
        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                System.out.println(fs.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
