// 4. First Move!

package tictactoe;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        char[][] board = new char[3][3];

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input[index];
                index++;
            }
        }
        printingBoard(board);

        int first = scanner.nextInt() - 1;
        int second = scanner.nextInt() - 1;

        boolean checker = false;
        while (!checker) {

            if (first < 0 || first > 2 || second < 0 || second > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                first = scanner.nextInt() - 1;
                second = scanner.nextInt() - 1;
            } else if (board[first][second] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                first = scanner.nextInt() - 1;
                second = scanner.nextInt() - 1;
            } else {
                board[first][second] = 'X';
                printingBoard(board);
                checker = true;
            }
        }
    }

    public static void printingBoard(char[][] board) {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }
}
