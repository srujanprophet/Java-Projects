package cinema;

import java.util.Scanner;

public class Cinema {

     static Scanner sc = new Scanner(System.in);
    static int purchased = 0;
    static float percent_purchased = 0;
    static int income = 0;
    static int total_income = 0;

    static void printRoom(char[][] room, int r, int s) {
        int k;
        System.out.println("\n" + "Cinema:");
        for(int i = 0; i < r+1; i++) {
            if(i == 0) {
                System.out.print("  ");
            }
            else {
                System.out.print(i + " ");
            }
            for(int j=1; j < s+1; j++) {
                if(i==0) {
                    System.out.print(j + " ");
                }
                else {
                    System.out.print(room[i-1][j-1] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println();
    } 

    static void buyTicket(char[][] room, int r, int s) {
        do {
            System.out.println("\nEnter a row number: ");
            int rno = sc.nextInt();
            System.out.println("Enter a seat number in that row: ");
            int sno = sc.nextInt();
            int total = r*s;
            int price;
            if((rno < 1 || sno < 1) || (rno > r || sno > s)) {
                System.out.println("\nWrong input!");
                continue;
            }
            if(room[rno-1][sno-1] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
                continue;
            }
            if(total <= 60) { 
                price = 10;
            } 
            else {
                int fh = r/2;
                int bh = r-fh;
                if(rno <= fh) price = 10;
                else price = 8;
            }
            System.out.println("Ticket Price: $"+price);
            room[rno-1][sno-1] = 'B';
            income += price;
            purchased += 1;
            return;
        } while(true);
    }

    static void statistics(char[][] room, int r, int s) {
        System.out.println("\nNumber of purchased tickets: " + purchased);
        percent_purchased = (float) (purchased*100.0)/(r*s);
        System.out.printf("Percentage %.2f%s\n",percent_purchased,'%');
        System.out.println("Current income: $" + income);
        if(r*s <= 60) { 
            total_income = r*s*10;
        } 
        else {
            int fh = r/2;
            int bh = r-fh;
            total_income = 10*fh + 8*bh;
        }
        System.out.println("Total income: $" + total_income*s);
    }

    public static void main(String[] args) {
        int r = 7;
        int s = 8;
        char[][] room = new char[r][s];
        System.out.print("Cinema:\n  ");
        for (int i = 1; i <= s; i++) System.out.print(i + " ");
        System.out.println();
        for(int i=1; i <= r; i++) {
            System.out.print(i + " ");
            for(int j=1; j <= s; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}
