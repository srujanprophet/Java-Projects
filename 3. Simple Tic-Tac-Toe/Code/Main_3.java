// 3. What's up on the Field?

package tictactoe;

import java.util.Scanner;

public class Main {
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        System.out.println("---------");
        System.out.println("| " + charArray[0] + " " + charArray[1] + " " + charArray[2] + " |");
        System.out.println("| " + charArray[3] + " " + charArray[4] + " " + charArray[5] + " |");
        System.out.println("| " + charArray[6] + " " + charArray[7] + " " + charArray[8] + " |");
        System.out.println("---------");
        int count = 0;
        int countX = 0;
        int countO = 0;
        int winner = 0;
        char winnerName = ' ';


        if (charArray[0] == charArray[1] && charArray[1] == charArray[2]) {
            winner++;
            winnerName = charArray[0];
        }
        if (charArray[3] == charArray[4] && charArray[4] == charArray[5]) {
            winner++;
            winnerName = charArray[3];
        }
        if (charArray[6] == charArray[7] && charArray[7] == charArray[8]) {
            winner++;
            winnerName = charArray[6];
        }
        if (charArray[0] == charArray[3] && charArray[3] == charArray[6]) {
            winner++;
            winnerName = charArray[0];
        }
        if (charArray[1] == charArray[4] && charArray[4] == charArray[7]) {
            winner++;
            winnerName = charArray[1];
        }
        if (charArray[2] == charArray[5] && charArray[5] == charArray[8]) {
            winner++;
            winnerName = charArray[2];
        }
        if (charArray[0] == charArray[4] && charArray[4] == charArray[8]) {
            winner++;
            winnerName = charArray[0];
        }
        if (charArray[2] == charArray[4] && charArray[4] == charArray[6]) {
            winner++;
            winnerName = charArray[2];
        }

        if (winner > 1) {
            System.out.println("Impossible");
        } else if (winner == 1) {
            System.out.println(winnerName + " wins");
        } else {
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '_') {
                    count++;
                }
                if (charArray[j] == 'O') {
                    countO++;
                }
                if (charArray[j] == 'X') {
                    countX++;
                }
            }
            if (countO != countX + 1 && countO != countX - 1 && countO != countX) {
                System.out.println("Impossible");
            } else if (count > 0) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        }
    }
}
