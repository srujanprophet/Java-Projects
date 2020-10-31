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
            StringBuilder before_dot = new StringBuilder();
            StringBuilder after_dot = new StringBuilder();
            int dot_hit = 0;
            for(int i=0; i<n.length(); i++) {
                if(n.charAt(i) == '.') dot_hit = 1;
                else if(dot_hit == 0) before_dot.append(n.charAt(i));
                else after_dot.append(n.charAt(i));
            }
            //System.out.println(before_dot + " " + after_dot);
            String int_part = (Integer.toString(Integer.parseInt(before_dot.toString(), src_radix), dest_radix));
            System.out.print(int_part);
            if(after_dot.length() != 0) {
                System.out.print(".");
                double num = 0;
                for(int i=0; i<after_dot.length(); i++) {
                    num += (Integer.parseInt(String.valueOf(after_dot.charAt(i)), src_radix)) / Math.pow(src_radix,i+1);
                }
                for(int i=0; i < 5; i++) {
                    double x = num * dest_radix;
                    System.out.print(Integer.toString((int)x, dest_radix));
                    num = x - (int)x;
                }
            }
            System.out.println();
        }
    }
}
