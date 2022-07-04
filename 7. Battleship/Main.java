package battleship;

import java.util.*;

class Location {
    int x,y;

    public Location(Scanner sc) {
        String location = sc.next();
        this.x = location.charAt(0) - 65;
        this.y = Integer.parseInt(location.substring(1)) - 1;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum Ship {
    AC("Aircraft Carrier", 5),
    BS("Battleship", 4),
    SM("Submarine", 3),
    CR("Cruiser", 3),
    DEST("Destroyer", 2);

    final String shipType;
    final int shipLen;
    Ship(String shipType, int shipLen) {
        this.shipType = shipType;
        this.shipLen = shipLen;
    }

    public int getShipLen() {
        return shipLen;
    }

    public String getShipType() {
        return shipType;
    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[][] board1 = new char[10][10];
    static char[][] board2 = new char[10][10];
    static char[][] fogBoard1 = new char[10][10];
    static char[][] fogBoard2 = new char[10][10];
    static HashMap<String, ArrayList<Location>> shipLocations1 = new HashMap<>();
    static HashMap<String, ArrayList<Location>> shipLocations2 = new HashMap<>();
    ;

    public static void initBoard(char[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
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

    public static void printBoard(char[][] board, char[][] fogboard) {
        printBoard(fogboard);
        System.out.println("---------------------");
        printBoard(board);
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

    public static boolean canPlace(char[][] board, int x1, int y1, int x2, int y2, int l, String ship) {
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 > 9 || x2 > 9 || y1 > 9 || y2 > 9) {
            System.out.println("\nError! Invalid coordinates! Try Again:");
            return false;
        } else if (x1 != x2 && y1 != y2) {
            System.out.println("\nError! Wrong ship location! Try Again");
            return false;
        } else if (x1 == x2 && Math.abs(y1 - y2) != (l-1)) {
            System.out.printf("\nError! Wrong length of %s\n", ship);
            return false;
        } else if (y1 == y2 && Math.abs(x1 - x2) != (l-1)) {
            System.out.printf("\nError! Wrong length of %s! Try Again\n", ship);
            return false;
        } else if (x1 == x2) {
            int y = Math.min(y1, y2);
            for (int i = 0; i < l; i++) {
                if (board[x1][y + i] == 'O') {
                    System.out.println("\nError! Ship already exists there! Try Again");
                    return false;
                }
                if (isTooClose(board, x1, y+i)) {
                    System.out.println("\nError! You placed it too close to another one. Try Again");
                    return false;
                }
            }
        } else if (y1 == y2) {
            int x = Math.min(x1, x2);
            for (int i = 0; i < l; i++) {
                if (board[x+i][y1] == 'O') {
                    System.out.println("\nError! Ship already exists there! Try Again");
                    return false;
                }
                if (isTooClose(board, x+i, y1)) {
                    System.out.println("\nError! You placed it too close to another one. Try Again");
                    return false;
                }
            }
        }
        return true;
    }

    public static void place(char[][] board, HashMap<String, ArrayList<Location>> shipLocations,
                             int grid, int start, int l, String type, char alignment) {
        ArrayList<Location> tempLocations = new ArrayList<>();
        if (alignment == 'V') {
            for (int i = 0; i < l; i++) {
                board[start+i][grid] = 'O';
                tempLocations.add(new Location(start+i, grid));
            }
        } else {
            for (int i = 0; i < l; i++) {
                board[grid][start + i] = 'O';
                tempLocations.add(new Location(grid, start+i));
            }
        }
        shipLocations.put(type, tempLocations);
    }

    public static void placeShip(char[][] board, HashMap<String, ArrayList<Location>> shipLocations,
                                 String type, int l) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("\nEnter the coordinates of the %s (%d cells):\n", type, l);
            Location loc1 = new Location(sc);
            Location loc2 = new Location(sc);
            // System.out.printf("%d %d %d %d\n", loc.x1, loc.y1, loc.x2, loc.y2);
            if (canPlace(board, loc1.x, loc1.y, loc2.x, loc2.y, l, type)) {
                if (loc1.x == loc2.x) {
                    place(board, shipLocations, loc1.x, Math.min(loc1.y, loc2.y), l, type,'H');
                    break;
                } else if (loc1.y == loc2.y) {
                    place(board, shipLocations, loc1.y, Math.min(loc1.x, loc2.x), l, type, 'V');
                    break;
                }
            }
        }
    }

    public static void placeShips(char[][] board, HashMap<String, ArrayList<Location>> shipLocations) {
        for (Ship ship: Ship.values()) {
            placeShip(board, shipLocations, ship.getShipType(), ship.getShipLen());
            printBoard(board);
        }
    }

    public static boolean hasShipSunk(char[][] board, HashMap<String, ArrayList<Location>> shipLocations) {
        boolean hasShipSank = true;
        for (Map.Entry<String, ArrayList<Location>> entry : shipLocations.entrySet()) {
            String key = entry.getKey();
            ArrayList<Location> shipLoc = entry.getValue();
            boolean sank = true;
            for (Location loc : shipLoc) {
                if (board[loc.x][loc.y] == 'O') sank = false;
            }
            if (!sank) {
                hasShipSank = false;
            } else {
                shipLocations.remove(key);
                if (shipLocations.isEmpty()) {
                    System.out.println("\nYou sank the last ship. You won. Congratulations!");
                } else {
                    System.out.println("\nYou sank a ship!");
                }
                return true;
            }
        }
        return hasShipSank;
    }

    public static void fire(char[][] board, char[][] fogBoard,
                            HashMap<String, ArrayList<Location>> shipLocations) {
        while (true) {
            Location loc = new Location(sc);
            int x = loc.x;
            int y = loc.y;
            if (x < 0 || y < 0 || x > 9 || y > 9) {
                System.out.println("\nError! Invalid coordinates! Try Again:");
            } else if (board[x][y] == '~') {
                board[x][y] = 'M';
                fogBoard[x][y] = 'M';
                System.out.println("\nYou missed!");
                break;
            } else if (board[x][y] == 'O') {
                board[x][y] = 'X';
                fogBoard[x][y] = 'X';
                if (hasShipSunk(board, shipLocations)) {
                    if (shipLocations.isEmpty()) {
                        return;
                    }
                } else {
                    System.out.println("\nYou hit a ship!");
                }
                break;
            } else if (board[x][y] == 'X') {
                System.out.println("\nYou hit a ship!");
                break;
            } else {
                System.out.println("\nYou missed!");
                break;
            }
        }
    }


    public static void main(String[] args) {
        // Write your code here
        initBoard(board1);
        initBoard(board2);
        initBoard(fogBoard1);
        initBoard(fogBoard2);

        // Place Ships
        System.out.println("\nPlayer 1, place your ships on the game field");
        printBoard(board1);
        placeShips(board1, shipLocations1);

        System.out.println("\nPress Enter and pass the move to another player");
        sc.nextLine();

        System.out.println("\nPlayer 2, place your ships on the game field");
        printBoard(board2);
        placeShips(board2, shipLocations2);

        System.out.println("\nPress Enter and pass the move to another player");
        sc.nextLine();

        // Game Starts
        int[] turns = {1, 2};
        int idx = 0;
        do {
            if (idx == 0) {
                printBoard(board1, fogBoard2);
                System.out.printf("\nPlayer %d, it's your turn:\n\n", turns[idx]);
                fire(board2, fogBoard2, shipLocations2);
            } else {
                printBoard(board2, fogBoard1);
                System.out.printf("\nPlayer %d, it's your turn:\n\n", turns[idx]);
                fire(board1, fogBoard1, shipLocations1);
            }
            System.out.println("Press Enter and pass the move to another player\n");
            sc.nextLine();
            sc.nextLine();
            idx ^= 1;
        } while (!shipLocations1.isEmpty() && !shipLocations2.isEmpty());
    }
}

