// 4. Signs of Intelligence

package tictactoe;

import java.util.*;

abstract class Player {
    abstract String makeMove(String state);
}


class ezAI extends Player {
    char turn;
    Random rnd = new Random();

    public ezAI(char ch) {
        System.out.println("I am an easy AI player");
        this.turn = ch;
    }

    protected String makeMove(String board) {
        int gridIdx;
        while (true) {
            int X = rnd.nextInt(3) + 1;
            int Y = rnd.nextInt(3) + 1;
            gridIdx = (3 * (X - 1)) + (Y - 1);
            if (board.charAt(gridIdx) == '_') {
                System.out.println("Making move level \"easy\"");
                break;
            }
        }
        char[] arr = board.toCharArray();
        arr[gridIdx] = this.turn;
        return String.valueOf(arr);
    }
}

class medAI extends Player {
    char turn;
    Random rnd = new Random();
    public medAI(char ch) {
        this.turn = ch;
    }

    private int moveLogic(String grid, char ch) {
        char c1 = grid.charAt(0);
        char c2 = grid.charAt(1);
        char c3 = grid.charAt(2);
        char c4 = grid.charAt(3);
        char c5 = grid.charAt(4);
        char c6 = grid.charAt(5);
        char c7 = grid.charAt(6);
        char c8 = grid.charAt(7);
        char c9 = grid.charAt(8);
        if (c1 == ch && c2 == ch && c3 == '_') return 2; // First row three cases
        else if (c1 == ch && c2 == '_' && c3 == ch) return 1;
        else if (c1 == '_' && c2 == ch && c3 == ch) return 0;
        else if (c4 == '_' && c5 == ch && c6 == ch) return 3; // Second row three cases
        else if (c4 == ch && c5 == '_' && c6 == ch) return 4;
        else if (c4 == ch && c5 == ch && c6 == '_') return 5;
        else if (c7 == ch && c8 == ch && c9 == '_') return 8; // Third row three cases
        else if (c7 == ch && c8 == '_' && c9 == ch) return 7;
        else if (c7 == '_' && c8 == ch && c9 == ch) return 6;
        else if (c1 == ch && c4 == ch && c7 == '_') return 6; // First column three cases
        else if (c1 == ch && c4 == '_' && c7 == ch) return 3;
        else if (c1 == '_' && c4 == ch && c7 == ch) return 0;
        else if (c2 == ch && c5 == ch && c8 == '_') return 7; // Second column three cases
        else if (c2 == ch && c5 == '_' && c8 == ch) return 4;
        else if (c2 == '_' && c5 == ch && c8 == ch) return 1;
        else if (c3 == ch && c6 == ch && c9 == '_') return 8; // Third column three cases
        else if (c3 == ch && c6 == '_' && c9 == ch) return 5;
        else if (c3 == '_' && c6 == ch && c9 == ch) return 2;
        else if (c1 == '_' && c5 == ch && c9 == ch) return 0; // Upper diagonal three cases
        else if (c1 == ch && c5 == '_' && c9 == ch) return 4;
        else if (c1 == ch && c5 == ch && c9 == '_') return 8;
        else if (c3 == '_' && c5 == ch && c7 == ch) return 2; // Lower diagonal three cases
        else if (c3 == ch && c5 == '_' && c7 == ch) return 4;
        else if (c3 == ch && c5 == ch && c7 == '_') return 6;
        else return -1;
    }

    protected String makeMove(String board) {
        int gridIdx;
        char[] arr = board.toCharArray();
        char opponent = (this.turn == 'X') ? 'O' : 'X';
        int winIdx = moveLogic(board, this.turn);
        int defIdx = moveLogic(board, opponent);
        if (winIdx != -1) {
            arr[winIdx] = this.turn;
        }
        else if (defIdx != -1) {
            arr[defIdx] = this.turn;
        }
        else {
            while (true) {
                int X = rnd.nextInt(3) + 1;
                int Y = rnd.nextInt(3) + 1;
                gridIdx = (3 * (X - 1)) + (Y - 1);
                if (board.charAt(gridIdx) == '_') {
                    System.out.println("Making move level \"medium\"");
                    break;
                }
            }
            arr[gridIdx] = this.turn;
        }
        return String.valueOf(arr);
    }
}

class Human extends Player {
    char turn;

    public Human(char ch) {
        System.out.println("I am a human player");
        this.turn = ch;
    }

    protected String makeMove(String board) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            Scanner sc = new Scanner(System.in);

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
            if (Integer.parseInt(x) > 3 || Integer.parseInt(y) > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            int X = Integer.parseInt(x);
            int Y = Integer.parseInt(y);
            int gridIdx = (3 * (X - 1)) + (Y - 1);
            if (board.charAt(gridIdx) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                char[] arr = board.toCharArray();
                arr[gridIdx] = this.turn;
                return String.valueOf(arr);
            }
        }
    }
}

class playerFactory {
    public Player getPlayer(String type, char turn) {
        if (type.equals("easy")) {
            return new ezAI(turn);
        } else if (type.equals("medium")) {
            return new medAI(turn);
        } else {
            return new Human(turn);
        }
    }
}


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

    static boolean isGameOver(String grid) {
        // showGrid(grid);
        if (isWinner(grid, 'X')) {
            System.out.println("X wins");
            return true;
        } else if (isWinner(grid, 'O')) {
            System.out.println("O wins");
            return true;
        } else if (grid.contains("_")) {
            return false;
        } else {
            System.out.println("Draw");
            return true;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        playerFactory p_factory = new playerFactory();

        while (true) {
            String board = "_________";
            System.out.println("Input command: ");
            String input = sc.nextLine();
            String[] inputs = input.split(" ");

            if (inputs[0].equals("exit")) break;

            if (inputs.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (!inputs[0].equals("start")) {
                System.out.println("Bad parameters!");
                continue;
            }

            Player player_1 = p_factory.getPlayer(inputs[1], 'X');
            Player player_2 = p_factory.getPlayer(inputs[2], 'O');

            showGrid(board);

            while (true) {
                board = player_1.makeMove(board);
                showGrid(board);
                if (isGameOver(board)) break;
                board = player_2.makeMove(board);
                showGrid(board);
                if (isGameOver(board)) break;
            }
       }
    }
}
