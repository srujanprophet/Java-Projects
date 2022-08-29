// 2. Easy Does It

package tictactoe;

import java.util.*;

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

    static boolean getCurrentState(String grid) {
        // showGrid(grid);
        if (isWinner(grid, 'X')) {
            System.out.println("X wins");
            return false;
        } else if (isWinner(grid, 'O')) {
            System.out.println("O wins");
            return false;
        } else if (grid.contains("_")) {
            return true;
        } else {
            System.out.println("Draw");
            return false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the cells: ");
//        String board = sc.nextLine();
        String board = "_________";
        showGrid(board);

        char[] turn = {'X', 'O'};
        boolean flag = true;
        int idx = 0; // For turn switching

//        int numX = (int) board.chars().filter(ch -> ch == 'X').count();
//        int numY = (int) board.chars().filter(ch -> ch == 'O').count();
//        if (numX == numY) turn = 'X';
//        else turn = 'O';

        do {
            int X,Y;
            int flag1 = 0;
            if (idx == 0) {
                System.out.print("Enter the coordinates: ");
                String x = sc.next();
                if (x.length() != 1) {
                    System.out.println("You should enter numbers!");
                    flag1 = 1;
                    continue;
                }
                String y = sc.next();
                if (y.length() != 1) {
                    System.out.println("You should enter numbers!");
                    flag1 = 1;
                    continue;
                }
                if (Integer.parseInt(x) > 3 || Integer.parseInt(y) > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    flag1 = 1;
                    continue;
                }
                X = Integer.parseInt(x);
                Y = Integer.parseInt(y);
            } else {
                Random rnd = new Random();
                while (true) {
                    X = rnd.nextInt(3) + 1;
                    Y = rnd.nextInt(3) + 1;
                    int gridSpot = (3 * (X - 1)) + (Y - 1);
                    if (board.charAt(gridSpot) == '_') {
                        System.out.println("Making move level \"easy\"");
                        break;
                    }
                }
            }
            int gridIdx = (3 * (X - 1)) + (Y - 1);

            if (board.charAt(gridIdx) != '_') System.out.println("This cell is occupied! Choose another one!");
            else {
                char[] arr = board.toCharArray();
                arr[gridIdx] = turn[idx];
                board = String.valueOf(arr);
                // printCurrentState(String.valueOf(arr));
                showGrid(board);
                idx ^= 1;
                flag = getCurrentState(board);
            }
       } while (flag);
    }
}
