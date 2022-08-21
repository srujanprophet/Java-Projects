// 1. Game Log

package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int code = rnd.nextInt(8999) + 1000;
        System.out.printf("The secret code is prepared: ****\n\n");
        int turns = 1;
        while (turns != 4) {
            int cow = rnd.nextInt(3) + 1;
            int bull = rnd.nextInt(4) + 1;
            int guess = rnd.nextInt(8999) + 1000;
            System.out.printf("Turn %d. Answer: \n%d\n", turns, guess);
            System.out.printf("Grade: %d cow\n\n", cow);
            turns++;
        }
        System.out.printf("Congrats! The secret code is %d.\n", code);
    }
}
