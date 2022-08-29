// 7. Error

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
            String word;
            if (cows == 1) word = "cow";
            else word = "cows";
            System.out.printf("Grade: %d %s\n", cows, word);
        } else if (cows == 0) {
            String word;
            if (bulls == 1) word = "bull";
            else word = "bulls";
            System.out.printf("Grade: %d %s\n", bulls, word);
        } else {
            String word1, word2;
            if (bulls == 1) word1 = "bull";
            else word1 = "bulls";
            if (cows == 1) word2 = "cow";
            else word2 = "cows";
            System.out.printf("Grade: %d %s and %d %s\n", bulls, word1, cows, word2);
        }
    }

    static String getCode(int len, int symbols) {
        StringBuilder code = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Math.min(10, symbols); i++) list.add(String.valueOf(i));
        for (int i = 97; i < (97 + symbols - 10); i++) list.add(String.valueOf((char)i));
        do {
            Collections.shuffle(list);
        } while (list.get(0).equals("0"));
        for (int i = 0; i < len; i++) code.append(list.get(i));
        StringBuilder range = new StringBuilder("(0-");
        if (symbols <= 10) range.append(symbols - 1);
        else {
            String end = String.valueOf((char)(97 + symbols - 11));
            range.append("9, a");
            if (!end.equals("a")) {
                range.append("-").append(end);
            }
        }
        range.append(").");
        System.out.printf("The secret is prepared: %s %s\n", "*".repeat(Math.max(0, len)), range);
        return code.toString();
    }

    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        String l;
        l = sc.nextLine();
        int len;
        try {
            len = Integer.parseInt(l);
        } catch (NumberFormatException e) {
            System.out.printf("Error: %s isn't a valid number\n", l);
            return;
        }
        if (len <= 0) {
            System.out.println("Error: Invalid length");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        int symbols = sc.nextInt();
        if (symbols < (len)) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols\n", len, symbols);
            return;
        }
        if (symbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        int turn = 1;
        System.out.println("Okay, let's start a game!");
        if (len > 10) {
            System.out.printf("Error! Can't generate a secret number with a " +
                    "length of %d because there aren't enough unique digits.", len);
            return;
        }
        String secret_code = getCode(len, symbols);
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
