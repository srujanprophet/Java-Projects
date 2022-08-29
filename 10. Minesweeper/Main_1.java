// 1. Lay the Groundwork

package minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<ArrayList<Character>> board = new ArrayList<>();

    static void init_board(int n) {
        for (int i = 0; i < n; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < n; j++) row.add('.');
            board.add(row);
        }
    }

    static void place_mines(int num_mines, int n, Random random) {
        int cnt = 0;
        while (cnt != num_mines) {
            int mine = random.nextInt(n*n);
            int r = mine / n;
            int c = mine % n;
            if (board.get(r).get(c) == '.') {
                board.get(r).add(c, 'X');
                cnt++;
            }
        }
    }

    static void print_board() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code here
        Random random = new Random();
        int n = 9;
        int num_mines = n - 1 + random.nextInt(5);

        init_board(n);

        place_mines(num_mines, n, random);

        print_board();
    }
}
