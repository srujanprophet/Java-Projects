// 5. Improve the Code Generator

package bullscows;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static void get_cowBull(String guess, String code) {
        int cows = 0, bulls = 0;
        for (int i = 0; i < code.length(); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                bulls++;
            }
            else if (code.contains(String.valueOf(guess.charAt(i)))) {
                cows++;
            }
        }
        if (bulls == 0) {
            System.out.printf("Grade: %d cow(s)\n", cows);
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s)\n", bulls);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bulls, cows);
        }
    }

    static String getCode(int len) {
        StringBuilder code = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        do {
            Collections.shuffle(list);
        } while (list.get(0) == 0);
        for (int i = 0; i < len; i++) code.append(list.get(i));
        return code.toString();
    }

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        int len = sc.nextInt();
        int turn = 1;
        System.out.println("Okay, let's start a game!");
        if (len > 10) {
            System.out.printf("Error! Can't generate a secret number with a " +
                    "length of %d because there aren't enough unique digits.", len);
            return;
        }
        String secret_code = getCode(len);
        while (true) {
            System.out.printf("Turn %d:\n", turn++);
            String guess = sc.next();
            get_cowBull(guess, secret_code);
            if (guess.equals(secret_code)) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
        }
    }
}
