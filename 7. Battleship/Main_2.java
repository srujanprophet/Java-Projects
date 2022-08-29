// 2. The First Shot

package battleship;

import java.util.*;

class Location {
    int x,y;

    public Location(Scanner sc) {
        String location = sc.next();
        this.x = location.charAt(0) - 65;
        this.y = Integer.parseInt(location.substring(1)) - 1;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = new char[10][10];

    public static void initBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
    }

    public static void printBoard() {
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

    public static boolean isTooClose(int x, int y) {
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

    public static boolean canPlace(int x1, int y1, int x2, int y2, int l, String ship) {
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 > 9 || x2 > 9 || y1 > 9 || y2 > 9) {
            System.out.println("Error! Invalid coordinates! Try Again:");
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
                if (isTooClose(x1, y+i)) {
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
                if (isTooClose(x+i, y1)) {
                    System.out.println("Error! You placed it too close to another one. Try Again");
                    return false;
                }
            }
        }
        return true;
    }

    public static void place(int grid, int start, int l, char alignment) {
        if (alignment == 'V') {
            for (int i = 0; i < l; i++) {
                board[start+i][grid] = 'O';
            }
        } else {
            for (int i = 0; i < l; i++) {
                board[grid][start + i] = 'O';
            }
        }
    }

    public static void placeShip(String type, int l) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Enter the coordinates of the %s (%d cells):", type, l);
            Location loc1 = new Location(sc);
            Location loc2 = new Location(sc);
            // System.out.printf("%d %d %d %d\n", loc.x1, loc.y1, loc.x2, loc.y2);
            if (canPlace(loc1.x, loc1.y, loc2.x, loc2.y, l, type)) {
                if (loc1.x == loc2.x) {
                    place(loc1.x, Math.min(loc1.y, loc2.y), l, 'H');
                    break;
                } else if (loc1.y == loc2.y) {
                    place(loc1.y, Math.min(loc1.x, loc2.x), l, 'V');
                    break;
                }
            }
        }
    }

    public static void placeShips() {
        placeShip("Aircraft Carrier", 5);
        printBoard();
        placeShip("Battleship", 4);
        printBoard();
        placeShip("Submarine", 3);
        printBoard();
        placeShip("Cruiser", 3);
        printBoard();
        placeShip("Destroyer", 2);
        printBoard();
    }

    public static void fire() {
        while (true) {
            System.out.println("\nTake a shot!\n");
            Location loc = new Location(sc);
            int x = loc.x;
            int y = loc.y;
            if (x < 0 || y < 0 || x > 9 || y > 9) {
                System.out.println("\nError! Invalid coordinates! Try Again:");
            } else if (board[x][y] == '~') {
                board[x][y] = 'M';
                printBoard();
                System.out.println("\nYou missed!\n");
                break;
            } else if (board[x][y] == 'O') {
                board[x][y] = 'X';
                printBoard();
                System.out.println("\nYou hit a ship!\n");
                break;
            } else if (board[x][y] == 'X' || board[x][y] == 'M') {
                System.out.println("\nError! Shot already taken there! Try Again:");
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here

        initBoard();
        printBoard();
        // Place Ships
        placeShips();
        // Game Starts
        System.out.println("\nThe game starts!\n");
        printBoard();
        fire();
    }
}

