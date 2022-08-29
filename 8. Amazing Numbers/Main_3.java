// 3. Palindromic Numbers

package numbers;

import java.util.*;

public class Main {

    static boolean isEvenNumber(long n) {
        return (n % 2 == 0);
    }

    static boolean isOddNumber(long n) {
        return (n % 2 != 0);
    }

    static boolean isBuzzNumber(long n) {
        if (n % 7 == 0 && n % 10 == 7) {
            return true;
        } else if (n % 7 == 0) {
            return true;
        } else return n % 10 == 7;
    }

    static boolean isDuckNumber(long n) {
        while (n != 0) {
            if (n % 10 == 0) return true;
            n = n / 10;
        }
        return false;
    }

    static boolean isPalindromeNumber(long n) {
        long rev = 0;
        long x = n;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n = n / 10;
        }
        return (x == rev);
    }

    public static void main(String[] args) {
//        write your code here
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter 0 to exit\n");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a request: ");
            long n = sc.nextLong();
            if (n < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero\n");
                continue;
            } else if (n == 0) {
                System.out.println("\nGoodbye!");
                break;
            } else {
                System.out.printf("Properties of %d\n", n);
                System.out.printf("\t\teven: %b\n", isEvenNumber(n));
                System.out.printf("\t\t odd: %b\n", isOddNumber(n));
                System.out.printf("\t\tbuzz: %b\n", isBuzzNumber(n));
                System.out.printf("\t\tduck: %b\n", isDuckNumber(n));
                System.out.printf(" palindromic: %b\n\n", isPalindromeNumber(n));
            }
        }
    }
}
