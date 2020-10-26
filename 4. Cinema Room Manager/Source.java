import java.util.Scanner;

public class Source {
    
    static void printRoom(int r, int s, int rno, int sno) {
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
                    if(rno == i && sno == j) 
                        System.out.print("B ");
                    else
                        System.out.print("S ");
                }
            }
            System.out.println("");
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int s = sc.nextInt();
        printRoom(r,s,-1,-1);
        System.out.println("Enter a row number: ");
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
        System.out.println("\nTicket Price: $"+price);
        printRoom(r,s,rno,sno);
    }
}