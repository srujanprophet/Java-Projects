import java.util.Scanner;

public class Source  {
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
	        int ctrx=0,ctro=0,ctrb=0;
	        for (int i=0; i<s.length(); i++) {
	            if (s.charAt(i) == 'X') ctrx++;
	            else if (s.charAt(i) == 'O') ctro++;
	            else ctrb++;
	        }
        	System.out.println("---------");
	        System.out.println("| " + s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2) + " |");
	        System.out.println("| " + s.charAt(3) + " " + s.charAt(4) + " " + s.charAt(5) + " |");
	        System.out.println("| " + s.charAt(6) + " " + s.charAt(7) + " " + s.charAt(8) + " |");
	        System.out.println("---------");
	        if ( winner(s, 'X') == true && winner(s, 'O') == true) System.out.println("Impossible");
	        else if ((ctrx >= (ctro+2)) || (ctro >= (ctrx+2))) System.out.println("Impossible");
	        else if ( winner(s, 'X') == true) System.out.println("X wins");
	        else if ( winner(s, 'O') == true) System.out.println("O wins");
	        else if ( winner(s, 'X') == false && winner(s, 'O') == false && ctrb == 0) System.out.println("Draw");
	        else if ( winner(s, 'X') == false && winner(s, 'O') == false && ctrb > 0) System.out.println("Game not finished");
    }
}
