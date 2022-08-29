// 2. Flexible Mines

package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Character>> board = new ArrayList<>();

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code here
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int n = 9;


        System.out.print("How many mines do you want on the field?  ");
        int num_mines = sc.nextInt();

        init_board(n);

        place_mines(num_mines, n, random);

        print_board(n);
    }
}
