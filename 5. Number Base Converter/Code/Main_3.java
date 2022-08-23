// 3. Convert to any Base

package converter;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    
   static void convert(int src_radix, int dest_radix, String n) {
       try {
            System.out.print("Conversion result: ");
            if (src_radix == 1) {
                int dec = n.length();
                System.out.println(Integer.toString(dec,dest_radix));
            } else if(dest_radix == 1) {
                int dec = Integer.parseInt(n,src_radix);
                for(int i=0; i < dec; i++) System.out.print("1");
            } else if (src_radix == dest_radix) System.out.print(n);
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
                String int_part = (Long.toString(Long.parseLong(before_dot.toString(), src_radix), dest_radix));
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
            }
        } catch (Exception e) {
            System.out.println("Error : Invalid conversions");
            return;
        }
   }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("\nEnter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String in1 = sc.next();
            if (in1.equals("/exit")) break;
            int src_radix = Integer.parseInt(in1); 
            int dest_radix = Integer.parseInt(sc.next());
            // error handling
            if (src_radix < 1 || src_radix > 36 || dest_radix < 1 || dest_radix > 36  ) {
                System.out.println("Error : Radix not valid");
                return;
            }
            while (true) {
                System.out.printf("\nEnter number in base %d to convert to base %d (To go back type /back) ", src_radix, dest_radix);
                String n = sc.next();
                if (n.equals("/back")) break;
                convert(src_radix, dest_radix, n);
            }
        }
    }
}
