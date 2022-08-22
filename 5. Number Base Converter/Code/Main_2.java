// 2. Convert to Decimal

package converter;

import java.util.Scanner;

public class Main {

public static String choose;
    public static Scanner sc = new Scanner(System.in);
    public static String stringAnswer = "";
    public static int intAnswer;
    public static boolean exit = false;
    public static int n = 0;
    public static int base = 0;
    public static boolean found = false;
    public static void main(String[] args) {
        do {
            n = 0;
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            choose = sc.next();
            
            switch (choose) {
                case "/from":
                    fromDecimal();
                    break;
                case "/to":
                    toDecimal();
            }
            System.out.println();
        } while (!"/exit".equals(choose));
        sc.close();
    }
    
    public static void toDecimal() {
        System.out.print("Enter source number: ");
        String number = sc.next();
        System.out.print("Enter source base: ");
        int base = sc.nextInt();

        switch (base) {
            case 16:
                intAnswer = convertFrom(number, base);
                break;
            case 8:
                intAnswer = convertFrom(number, base);
                break;
            case 2:
                intAnswer = convertFrom(number, base);
        }
        if (!exit) {
            System.out.println("Conversion to decimal result: " + intAnswer);
        }
    }

    public static void fromDecimal() {
        System.out.print("Enter a number in decimal system: ");
        int number = sc.nextInt();
        System.out.print("Enter the target base: ");
        int base = sc.nextInt();

        switch (base) {
            case 16:
                stringAnswer = convertTo(number, base); 
                break;
            case 8:
                stringAnswer = convertTo(number, base); 
                break;
            case 2:
                stringAnswer = convertTo(number, base);
            }
            if (!exit) {
                System.out.println("Conversion result: " + stringAnswer);
            }
    }
    public static String convertTo(int number, int base) {
        if (base == 2) {return Integer.toBinaryString(number);}
        if (base == 8) {return Integer.toOctalString(number);}
        if (base == 16) {return Integer.toHexString(number).toUpperCase();}
        return null;
    }

    public static int convertFrom(String number, int base) {
        int result = 0; int digit = 0; String alphabets = "abcdef";
        for (int i = number.length() - 1; i >= 0; i--) {
            for (int j = 0; j < alphabets.length(); j++) {
                if (number.charAt(i) == alphabets.charAt(j)) {
                    digit = (int) number.charAt(i) - 87;
                    result += Math.pow(base, n) * digit;
                    found = true;
                } 
            } 
            if (!found) {
                result += Math.pow(base, n) * Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            n++; found = false;
        }
        return result;
    }
}
