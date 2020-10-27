import java.util.Scanner;

public class Source {
    
    static Scanner sc = new Scanner(System.in);

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
        System.out.println("\nEnter a row number: ");
        int rno = sc.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int sno = sc.nextInt();
        int total = r*s;
        int price;
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
        //printRoom(r,s,rno,sno);
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int s = sc.nextInt();
        char[][] room = new char[r][s];
        for(int i=0; i < r; i++) {
            for(int j=0; j < s; j++) {
                room[i][j] = 'S';
            }
        }
        int choice = -1;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
            choice = sc.nextInt();
            if(choice == 1) printRoom(room, r, s);
            if(choice == 2) buyTicket(room, r, s);
        } while(choice != 0);
    }
}