package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Character>> board = new ArrayList<>();
    static ArrayList<ArrayList<Character>> game_board = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int[] X = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] Y = {-1, 0, 1, -1, 1, -1, 0, 1};
    static ArrayList<Integer> mine_locations = new ArrayList<>();

    static void init_board(int n) {
        board.clear();
        for (int i = 0; i < n; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < n; j++) row.add('.');
            board.add(row);
        }
    }

    static void init_game_board(int n) {
        game_board.clear();
        for (int i = 0; i < n; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (board.get(i).get(j) == 'X') row.add('.');
                else row.add(board.get(i).get(j));
            }
            game_board.add(row);
        }
    }

    static void place_mines(int num_mines, int n, Random random, int first) {
        int cnt = 0;
        while (cnt < num_mines) {
            int mine = random.nextInt(n*n);
            if (mine == first) continue;
            int r = mine / n;
            int c = mine % n;
            if (board.get(r).get(c) == '.') {
                board.get(r).set(c, 'X');
                mine_locations.add(mine);
                cnt++;
            }
        }
    }

    static void print_board(int n) {
        System.out.print("\n |");
        for (int i = 1; i <= n; i++) System.out.print(i);
        System.out.printf("|\n-|%s|\n", "-".repeat(n));

        for (int i = 1; i <= n; i++) {
            System.out.print(i + "|");
            for (int j = 1; j <= n; j++) {
                System.out.print(board.get(i-1).get(j-1));
            }
            System.out.println("|");
        }
        System.out.printf("-|%s|\n", "-".repeat(n));
    }

    static void print_game_board(int n) {
        System.out.print("\n |");
        for (int i = 1; i <= n; i++) System.out.print(i);
        System.out.printf("|\n-|%s|\n", "-".repeat(n));

        for (int i = 1; i <= n; i++) {
            System.out.print(i + "|");
            for (int j = 1; j <= n; j++) {
                System.out.print(game_board.get(i-1).get(j-1));
            }
            System.out.println("|");
        }
        System.out.printf("-|%s|\n", "-".repeat(n));
    }

    static void get_neighborhood(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ctr = 0;
                if (board.get(i).get(j) != 'X') {
                    for (int k = 0; k < 8; k++) {
                        int x = i + X[k];
                        int y = j + Y[k];
                        if (!(x < 0 || y < 0 || x > n-1 || y > n-1)) {
                            if (board.get(i+X[k]).get(j+Y[k]) == 'X') ctr++;
                        }
                    }
                }
                if (ctr > 0) board.get(i).set(j, (char)(ctr + '0'));
            }
        }
    }

    static void explore(int i, int j, int n) {
        for (int k = 0; k < 8; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (!(x < 0 || y < 0 || x > n-1 || y > n-1)) {
                if (game_board.get(x).get(y) == '*' && board.get(x).get(y) != 'X')
                    game_board.get(x).set(y, board.get(x).get(y));
                if (board.get(x).get(y) == 'X') {
                    game_board.get(i).set(j, board.get(i).get(j));
                    return;
                } else if (board.get(x).get(y) > '0' && board.get(x).get(y) < '9') {
                    game_board.get(x).set(y, board.get(x).get(y));
                } else if (game_board.get(x).get(y) == '.') {
                    game_board.get(x).set(y, '/');
                    explore(x, y, n);
                }
            }
        }
    }

    static boolean isAllExplored(int num_mines, int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board.get(i).get(j) == '/') cnt++;
                if (game_board.get(i).get(j) < '9' && game_board.get(i).get(j) > '0') cnt++;
            }
        }
        return ((n * n) - cnt) == num_mines;
    }


    static void play(int num_mines, int n) {
        int mines = 0, marks = 0;
        Random random = new Random();
        while (true) {
            boolean isAllExplored = isAllExplored(num_mines, n);
            if (marks == mines && mines == num_mines || isAllExplored) {
                System.out.println("Congratulations! You found all mines!");
                return;
            }
            System.out.print("Set/unset mines marks or claim a cell as free: ");
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            String action = sc.next();

            if (mine_locations.isEmpty()) {
                place_mines(num_mines, n, random, x*n + y);
                get_neighborhood(n);
            }

            if (action.equals("free")) {
                if (board.get(x).get(y) == '.') {
                    game_board.get(x).set(y, '/');
                    explore(x, y, n);
                } else if (board.get(x).get(y) == 'X') {
                    for (Integer mine : mine_locations) game_board.get(mine / n).set(mine % n, 'X');
                    print_game_board(n);
                    System.out.println("You stepped on a mine and failed!");
                    return;
                } else game_board.get(x).set(y, board.get(x).get(y));
            } else if (action.equals("mine")) {
                if (game_board.get(x).get(y) == '*') {
                    marks--;
                    game_board.get(x).set(y, '.');
                    if (board.get(x).get(y) == 'X') {
                        mines--;
                    }
                } else if (board.get(x).get(y) == 'X' && game_board.get(x).get(y) == '.') {
                    game_board.get(x).set(y, '*');
                    marks++; mines++;
                } else if (board.get(x).get(y) == '.' && game_board.get(x).get(y) != '/') {
                    marks++;
                    game_board.get(x).set(y, '*');
                } else { // Numbers case, trying with same as above
                    marks++;
                    game_board.get(x).set(y, '*');
                }
            }
            print_game_board(n);
        }
    }

    public static void main(String[] args) {
        // write your code here
        int n = 9;


        System.out.print("How many mines do you want on the field?  ");
        int num_mines = sc.nextInt();

        init_board(n);
        init_game_board(n);

        print_board(n);

        play(num_mines, n);
    }
}
