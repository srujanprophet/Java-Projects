import java.util.Scanner;
public class Source {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int s = sc.nextInt();
        System.out.println("Total Income: ");
        int total = r*s;
        if(total <= 60) { 
            System.out.println("$"+(total*10));
        } 
        else {
            int fh = r/2;
            int bh = r-fh;
            int cost = fh*10*s + bh*8*s;
            System.out.println("$"+cost); 
        }
    }
}