// 1. Initial Setup

package tictactoe;

import java.util.Scanner;

public class Main {

    static void showGrid(String grid) {
        System.out.println("---------");
        System.out.println("| " + grid.charAt(0) + " " + grid.charAt(1) + " " + grid.charAt(2) + " |");
        System.out.println("| " + grid.charAt(3) + " " + grid.charAt(4) + " " + grid.charAt(5) + " |");
        System.out.println("| " + grid.charAt(6) + " " + grid.charAt(7) + " " + grid.charAt(8) + " |");
        System.out.println("---------");
    }

    static boolean isWinner(String grid, char ch) {
        char c1 = grid.charAt(0);
        char c2 = grid.charAt(1);
        char c3 = grid.charAt(2);
        char c4 = grid.charAt(3);
        char c5 = grid.charAt(4);
        char c6 = grid.charAt(5);
        char c7 = grid.charAt(6);
        char c8 = grid.charAt(7);
        char c9 = grid.charAt(8);
        if (c1 == ch && c2 == ch && c3 == ch) return true;
        if (c4 == ch && c5 == ch && c6 == ch) return true;
        if (c7 == ch && c8 == ch && c9 == ch) return true;
        if (c1 == ch && c4 == ch && c7 == ch) return true;
        if (c2 == ch && c5 == ch && c8 == ch) return true;
        if (c3 == ch && c6 == ch && c9 == ch) return true;
        if (c1 == ch && c5 == ch && c9 == ch) return true;
        if (c3 == ch && c5 == ch && c7 == ch) return true;
        return false;
    }

    static void printCurrentState(String grid) {
        showGrid(grid);
        if (isWinner(grid, 'X')) System.out.println("X wins");
        else if (isWinner(grid, 'O')) System.out.println("O wins");
        else if (grid.contains("_")) System.out.println("Game not finished");
        else System.out.println("Draw");
    }

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the cells: ");
        String board = sc.nextLine();
        showGrid(board);

        char turn;
        boolean flag = true;

        int numX = (int) board.chars().filter(ch -> ch == 'X').count();
        int numY = (int) board.chars().filter(ch -> ch == 'O').count();
        if (numX == numY) turn = 'X';
        else turn = 'O';

        do {
            System.out.print("Enter the coordinates: ");
            String x = sc.next();
            if (x.length() != 1) {
                System.out.println("You should enter numbers!");
                continue;
            }
            String y = sc.next();
            if (y.length() != 1) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // if (x.length() != 1 || y.length() != 1) System.out.println("You should enter numbers!");
            if (Integer.parseInt(x) > 3 || Integer.parseInt(y) > 3)
                System.out.println("Coordinates should be from 1 to 3!");
            else {
                int X = Integer.parseInt(x);
                int Y = Integer.parseInt(y);

                int gridIdx = (3 * (X - 1)) + (Y - 1);

                if (board.charAt(gridIdx) != '_') System.out.println("This cell is occupied! Choose another one!");
                else {
                    char[] arr = board.toCharArray();
                    arr[gridIdx] = turn;
                    printCurrentState(String.valueOf(arr));
                    flag = false;
                }
            }
        } while (flag);
    }
}
