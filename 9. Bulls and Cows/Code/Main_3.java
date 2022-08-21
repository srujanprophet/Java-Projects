// 3. Secret Code

package bullscows;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static void get_cowBull() {
        Random rnd = new Random();
        int code = rnd.nextInt(8999) + 1000;
        //System.out.printf("The secret code is prepared: ****\n\n");
        String guess = sc.next();
        int cows = 0, bulls = 0;
        for (int i = 0; i < 4; i++) {
            String ans = String.valueOf(code);
            if (guess.charAt(i) == ans.charAt(i)) bulls++;
            else if (ans.contains(String.valueOf(guess.charAt(i)))) cows++;
        }
        if (bulls == 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %d.", cows, code);
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %d.", bulls, code);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %d.", cows, bulls, code);
        }
    }

    public static void main(String[] args) {
        int len = sc.nextInt();
        if (len > 10) {
            System.out.printf("Error! Can't generate a secret number with a " +
                    "length of %d because there aren't enough unique digits.", len);
            return;
        }
        long pseudoRandomNumber = System.nanoTime();
        StringBuilder code = new StringBuilder();
        while (code.length() != len) {
            Long digit = pseudoRandomNumber % 10;
            int isUnique = code.indexOf(Long.toString(digit));
            if ((code.length() == 0 && digit == 0) || isUnique != -1) {
                pseudoRandomNumber /= 10;
                if (pseudoRandomNumber == 0L) pseudoRandomNumber = System.nanoTime();
                continue;
            }
            code.append(String.valueOf(digit));
            pseudoRandomNumber /= 10;
            if (pseudoRandomNumber == 0L) pseudoRandomNumber = System.nanoTime();
        }
        System.out.printf("The random secret number is %s", code);
    }
}
