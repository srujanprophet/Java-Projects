// 2. ASCII Homes

package asciimirror;

import java.util.*;

public class Main {
    static void moo() {
//        System.out.printf("%s_______ \n", " ".repeat(20));
//        System.out.printf("%s< hello >\n", " ".repeat(19));
//        System.out.printf("%s%s \n"," ".repeat(20), "-".repeat(7));
        System.out.printf("%s^__^\n", " ".repeat(12), " ".repeat(8));
        System.out.printf("    %s/(oo)\n", "_".repeat(7));
        System.out.printf("/\\/(%s/(__)\n", " ".repeat(7));
        System.out.printf("   | w----||    \n");
        System.out.printf("   ||%s||    \n"," ".repeat(5));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the file path:");
        String input = sc.nextLine();
        System.out.println(input);
        moo();
    }
}
