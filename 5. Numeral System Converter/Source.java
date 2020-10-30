import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int src_radix = sc.nextInt();
        String n = sc.next();
        int dest_radix = sc.nextInt();
        if (src_radix == 1) {
            int dec = n.length();
            System.out.println(Integer.toString(dec,dest_radix));
        } else if(dest_radix == 1) {
            int dec = Integer.parseInt(n,src_radix);
            for(int i=0; i < dec; i++) System.out.print("1");
            System.out.println();
        }
        else {
            System.out.println(Integer.toString(Integer.parseInt(n, src_radix), dest_radix));
        }
    }
}
