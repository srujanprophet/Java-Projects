package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String[] dict = sc.nextLine().split(" ");
        Collections.addAll(words, dict);
        String search = sc.next();
        int idx = words.indexOf(search);
        if (idx == -1) System.out.println("Not found");
        else System.out.println(idx+1);
    }
}
