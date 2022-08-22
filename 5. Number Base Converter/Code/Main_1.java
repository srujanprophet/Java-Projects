// 1. Convert Decimals

package converter;

import java.util.Scanner;

public class Main {

      public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number in decimal system: ");
        int number = scanner.nextInt();
        System.out.println("Enter target base: ");
        int decimal = scanner.nextInt();
        System.out.print("Conversion result: ");
        System.out.print(binHexOct(number,decimal));
    }
    
    public static String binHexOct(int number, int decimal) {
        switch(decimal) {
            case 2 -> {
                return Integer.toBinaryString(number);       
            }
            case 8 -> {
                return Integer.toOctalString(number);
            }
            case 16 -> {
                return Integer.toHexString(number);
            }
            default -> {
                return "invalid inputs.";
            }
        }
    }  
}
