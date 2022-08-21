// 2. Duck Numbers
package numbers;

import java.util.*;

public class Main {

    static boolean isEvenNumber(int n) {
        return (n % 2 == 0);
    }

    static boolean isOddNumber(int n) {
        return (n % 2 != 0);
    }

    static boolean isBuzzNumber(int n) {
        if (n % 7 == 0 && n % 10 == 7) {
            return true;
        } else if (n % 7 == 0) {
            return true;
        } else return n % 10 == 7;
    }

    static boolean isDuckNumber(int n) {
        while (n != 0) {
            if (n % 10 == 0) return true;
            n = n / 10;
        }
        return false;
    }

    public static void main(String[] args) {
//        write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("This number is not natural!");
            return;
        }
        System.out.printf("Properties of %d\n", n);
        System.out.printf("\teven: %b\n", isEvenNumber(n));
        System.out.printf("\todd: %b\n", isOddNumber(n));
        System.out.printf("\tbuzz: %b\n", isBuzzNumber(n));
        System.out.printf("\tduck: %b\n", isDuckNumber(n));
    }
}
