// 1. ASCII Lands Welcome You, Stranger

package asciimirror;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%s_______ \n", " ".repeat(20));
        System.out.printf("%s< hello >\n", " ".repeat(19));
        System.out.printf("%s%s \n"," ".repeat(20), "-".repeat(7));
        System.out.printf("%s^__^   /%s\n", " ".repeat(12), " ".repeat(8));
        System.out.printf("    %s/(oo)  /%s\n", "_".repeat(7), " ".repeat(9));
        System.out.printf("/\\/(%s/(__)%s\n", " ".repeat(7), " ".repeat(12));
        System.out.printf("   | w----||%s\n", " ".repeat(16));
        System.out.printf("   ||%s||%s\n"," ".repeat(5), " ".repeat(16));
    }
}
