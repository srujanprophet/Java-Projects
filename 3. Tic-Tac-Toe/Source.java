import java.util.Scanner;

public class Source {
    
    public static boolean winner(String s, char ch) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(2);
        char c4 = s.charAt(3);
        char c5 = s.charAt(4);
        char c6 = s.charAt(5);
        char c7 = s.charAt(6);
        char c8 = s.charAt(7);
        char c9 = s.charAt(8);
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cells: ");
        String s = sc.next();
        System.out.println("---------");
        System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
        System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
        System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
        System.out.println("---------");
        int flag = 1;   
        char[] arr = new char[9];
        do {
            System.out.print("Enter the coordinates: ");
            String x = sc.next();
            String y = sc.next();
            for (int i=0; i<s.length(); i++) arr[i] = s.charAt(i);
            if (Integer.valueOf(x) > 3 || Integer.valueOf(y) > 3) System.out.println("Coordinates should be from 1 to 3!");
            else if (x.length() != 1 || y.length() != 1) System.out.println("You should enter numbers!");
            else {
                int X = Integer.valueOf(x);
                int Y = Integer.valueOf(y);
                if ( X == 1 && Y == 1 && s.charAt(6) == '_') {
                    arr[6] = 'X';
                    flag = 0;
                }
                else if ( X == 1 && Y == 2 && s.charAt(3) == '_') {
                    arr[3] = 'X';
                    flag = 0;
                }
                else if ( X == 1 && Y == 3 && s.charAt(0) == '_') {
                    arr[0] = 'X';
                    flag = 0;
                }
                else if ( X == 2 && Y == 1 && s.charAt(7) == '_') {
                    arr[7] = 'X';
                    flag = 0;
                }
                else if ( X == 2 && Y == 2 && s.charAt(4) == '_') {
                    arr[4] = 'X';
                    flag = 0;
                }
                else if ( X == 2 && Y == 3 && s.charAt(1) == '_') {
                    arr[1] = 'X';
                    flag = 0;
                }
                else if ( X == 3 && Y == 1 && s.charAt(8) == '_') {
                    arr[8] = 'X';
                    flag = 0;
                }
                else if ( X == 3 && Y == 2 && s.charAt(5) == '_') {
                    arr[5] = 'X';
                    flag = 0;
                }
                else if ( X == 3 && Y == 3 && s.charAt(2) == '_') {
                    arr[2] = 'X';
                    flag = 0;
                }
                else System.out.println("This cell is occupied! Choose another one!");   
            }
        } while (flag == 1);
        String s1 = String.valueOf(arr);
        System.out.println("---------");
        System.out.println("| " + s1.charAt(0) + " " + s1.charAt(1) + " " + s1.charAt(2) + " |");
        System.out.println("| " + s1.charAt(3) + " " + s1.charAt(4) + " " + s1.charAt(5) + " |");
        System.out.println("| " + s1.charAt(6) + " " + s1.charAt(7) + " " + s1.charAt(8) + " |");
        System.out.println("---------");
    }
}

