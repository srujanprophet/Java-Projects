// 2. Grader

package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
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
}
