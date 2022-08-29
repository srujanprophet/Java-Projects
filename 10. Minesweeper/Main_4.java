// 4. Prepare For Battle

package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Character>> board = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void init_board(int n) {
        board.clear();
        for (int i = 0; i < n; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < n; j++) row.add('.');
            board.add(row);
        }
    }

    static void place_mines(int num_mines, int n, Random random) {
        int cnt = 0;
        while (cnt < num_mines) {
            int mine = random.nextInt(n*n);
            int r = mine / n;
            int c = mine % n;
            if (board.get(r).get(c) == '.') {
                board.get(r).set(c, 'X');
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
                if (board.get(i-1).get(j-1) == 'X') System.out.print(".");
                else System.out.print(board.get(i-1).get(j-1));
            }
            System.out.println("|");
        }
        System.out.printf("-|%s|\n", "-".repeat(n));
    }

    static void get_neighborhood(int n) {
        int[] X = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] Y = {-1, 0, 1, -1, 1, -1, 0, 1};
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

    static void play(int num_mines, int n) {
        int mines = 0, marks = 0;
        ArrayList<Integer> mine_locations = new ArrayList<>();
        while (true) {
            if (marks == mines && mines == num_mines) {
                System.out.println("Congratulations! You found all mines!");
                return;
            }
            System.out.println("Set/delete mines marks (x and y coordinates): ");
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            if (board.get(x).get(y) == 'X' || board.get(x).get(y) == '.') {
                marks++;
                if (board.get(x).get(y) == 'X') {
                    mines++;
                    mine_locations.add((x * n) + y);
                } else if (mine_locations.contains((x * n) + y)) mines++;
                board.get(x).set(y, '*');
                print_board(n);
            } else if (board.get(x).get(y) == '*') {
                board.get(x).set(y, '.');
                marks--;
                if (mine_locations.contains((x * n) + y)) mines--;
                print_board(n);
            }
            else System.out.println("There is a number here!");
        }
    }

    public static void main(String[] args) {
        // write your code here
        Random random = new Random();
        int n = 9;


        System.out.print("How many mines do you want on the field?  ");
        int num_mines = sc.nextInt();

        init_board(n);

        place_mines(num_mines, n, random);

        get_neighborhood(n);

        print_board(n);

        play(num_mines, n);
    }
}
