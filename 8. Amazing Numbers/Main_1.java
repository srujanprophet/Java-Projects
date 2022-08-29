// 1. Buzz Numbers

package numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("This number is not natural!");
            return;
        }
        if (n % 2 == 0) System.out.println("This number is Even");
        else System.out.println("This number is Odd");

        if (n % 7 == 0 && n % 10 == 7) {
            System.out.println("It is a Buzz number");
            System.out.printf("Explanation:\n%d is divisible by 7 and ends with 7\n", n);
        } else if (n % 7 == 0) {
            System.out.println("It is a Buzz number");
            System.out.printf("Explanation:\n%d is divisible by 7\n", n);
        } else if (n % 10 == 7) {
            System.out.println("It is a Buzz number");
            System.out.printf("Explanation:\n%d ends with 7\n", n);
        } else {
            System.out.println("It is not a Buzz number");
            System.out.printf("Explanation:\n%d is neither divisible by 7 nor does it end with 7\n", n);
        }
    }
}
