// 1. Welcome to the Battlefield

package tictactoe;

import java.util.Scanner;

public class Main {
     public static boolean winner(char[] a, char ch) {
        char c1 = a[0];
        char c2 = a[1];
        char c3 = a[2];
        char c4 = a[3];
        char c5 = a[4];
        char c6 = a[5];
        char c7 = a[6];
        char c8 = a[7];
        char c9 = a[8];
        if ( c1 == ch && c2 == ch && c3 == ch) return true;
        if ( c4 == ch && c5 == ch && c6 == ch) return true;
        if ( c7 == ch && c8 == ch && c9 == ch) return true;
        if ( c1 == ch && c4 == ch && c7 == ch) return true;
        if ( c2 == ch && c5 == ch && c8 == ch) return true;
        if ( c3 == ch && c6 == ch && c9 == ch) return true;
        if ( c1 == ch && c5 == ch && c9 == ch) return true;
        if ( c3 == ch && c5 == ch && c7 == ch) return true;
        return false;
    }
    
    public static void printA(char[] arr) {
        String s1 = String.valueOf(arr);
        System.out.println("---------");
        System.out.println("| " + s1.charAt(0) + " " + s1.charAt(1) + " " + s1.charAt(2) + " |");
        System.out.println("| " + s1.charAt(3) + " " + s1.charAt(4) + " " + s1.charAt(5) + " |");
        System.out.println("| " + s1.charAt(6) + " " + s1.charAt(7) + " " + s1.charAt(8) + " |");
        System.out.println("---------");
    }
    
    public static boolean draw(char[] arr) {
        if (winner(arr, 'X') == true || winner(arr, 'O') == true) return false;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == ' ') return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "XOXXOOXOX";
        //System.out.println("---------");
        System.out.println(s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2));
        System.out.println(s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5));
        System.out.println(s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8));
        //System.out.println("---------");
        int flag = 1;   
        char[] arr = new char[9];
        char turn = 'O';
        
    }
}
