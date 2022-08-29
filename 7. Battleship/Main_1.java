// 1. Take Position

package battleship;

import java.util.*;

class Location {
    int x1, x2, y1, y2;

    public Location() {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        String end = sc.next();
        this.x1 = start.charAt(0) - 65;
        this.y1 = Integer.parseInt(start.substring(1)) - 1;
        this.x2 = end.charAt(0) - 65;
        this.y2 = Integer.parseInt(end.substring(1)) - 1;
    }
}

public class Main {

    public static char[][] initBoard(char[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) System.out.printf("%d ", (i+1));
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%c ", (char) (65 + i));
            for (int j = 0; j < 10; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isTooClose(char[][] board, int x, int y) {
        int[] x_moves = {1, -1, 0, 0};
        int[] y_moves = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int x1 = x + x_moves[i];
            int y1 = y + y_moves[i];
            if (x1 < 0 || y1 < 0 || x1 > 9 || y1 > 9) continue;
            if (board[x1][y1] == 'O') return true;
        }
        return false;
    }

    public static boolean canPlace(int x1, int y1, int x2, int y2, int l, String ship, char[][] board) {
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 > 9 || x2 > 9 || y1 > 9 || y2 > 9) {
            System.out.println("Error! Invalid co-ordinates, check limits.");
            return false;
        } else if (x1 != x2 && y1 != y2) {
            System.out.println("Error! Wrong ship location! Try Again");
            return false;
        } else if (x1 == x2 && Math.abs(y1 - y2) != (l-1)) {
            System.out.printf("Error! Wrong length of %s\n", ship);
            return false;
        } else if (y1 == y2 && Math.abs(x1 - x2) != (l-1)) {
            System.out.printf("Error! Wrong length of %s! Try Again\n", ship);
            return false;
        } else if (x1 == x2) {
            int y = Math.min(y1, y2);
            for (int i = 0; i < l; i++) {
                if (board[x1][y + i] == 'O') {
                    System.out.println("Error! Ship already exists there! Try Again");
                    return false;
                }
                if (isTooClose(board, x1, y+i)) {
                    System.out.println("Error! You placed it too close to another one. Try Again");
                    return false;
                }
            }
        } else if (y1 == y2) {
            int x = Math.min(x1, x2);
            for (int i = 0; i < l; i++) {
                if (board[x+i][y1] == 'O') {
                    System.out.println("Error! Ship already exists there! Try Again");
                    return false;
                }
                if (isTooClose(board, x+i, y1)) {
                    System.out.println("Error! You placed it too close to another one. Try Again");
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] place(char[][] board, int grid, int start, int l, char alignment) {
        if (alignment == 'V') {
            for (int i = 0; i < l; i++) {
                board[start+i][grid] = 'O';
            }
        } else {
            for (int i = 0; i < l; i++) {
                board[grid][start+i] = 'O';
            }
        }
        return board;
    }

    public static char[][] placeShip(char[][] board, String type, int l) {
        // Placing Aircraft Carrier
        while (true) {
            System.out.printf("Enter the coordinates of the %s (%d cells):", type, l);
            Location loc = new Location();
            // System.out.printf("%d %d %d %d\n", loc.x1, loc.y1, loc.x2, loc.y2);
            if (canPlace(loc.x1, loc.y1, loc.x2, loc.y2, l, type, board)) {
                if (loc.x1 == loc.x2) {
                    board = place(board, loc.x1, Math.min(loc.y1, loc.y2), l, 'H');
                    break;
                } else if (loc.y1 == loc.y2) {
                    board = place(board, loc.y1, Math.min(loc.x1, loc.x2), l, 'V');
                    break;
                }
            }
        }
        return board;
    }

    public static char[][] placeShips(char[][] board) {
        board = placeShip(board, "Aircraft Carrier", 5);
        printBoard(board);
        board = placeShip(board, "Battleship", 4);
        printBoard(board);
        board = placeShip(board, "Submarine", 3);
        printBoard(board);
        board = placeShip(board, "Cruiser", 3);
        printBoard(board);
        board = placeShip(board, "Destroyer", 2);
        printBoard(board);
        return board;
    }

    public static void main(String[] args) {
        // Write your code here
        char[][] board = new char[10][10];

        board = initBoard(board);
        printBoard(board);
        board = placeShips(board);
    }
}

