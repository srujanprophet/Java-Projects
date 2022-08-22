// 3. Convert to Any Base

package converter;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

public static String choose;
    public static Scanner sc = new Scanner(System.in);
    public static String back = "/back";
    public static BigInteger result;
    public static void main(String[] args) {
        do {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            choose = sc.nextLine();
            if (!choose.equals("/exit")) {
                String[] numbers = choose.split(" ");
                convert(numbers);
            }
        } while (!choose.equals("/exit"));
    }

    public static void convert(String[] numbers) {
        do {
            System.out.print("Enter number in base " + numbers[0] + " to convert to base " + numbers[1] + " (To go back type /back) ");
            choose = sc.nextLine();
            if (!choose.equals("/back")) { 
                System.out.println("Conversion result: " + convertToTargetBase(convertToDecimal(choose, numbers[0]), numbers[1]));
            }
        } while (!choose.equals("/back"));
    }

    public static BigInteger convertToDecimal(String number, String base) {
        result = new BigInteger(number, Integer.parseInt(base));
        return result;
    }

    public static String convertToTargetBase(BigInteger number, String targetBase) {
        BigInteger num = new BigInteger(String.valueOf(number));
        BigInteger target = new BigInteger(targetBase);
        StringBuilder result = new StringBuilder();
        while (!num.equals(BigInteger.ZERO)) {
            int remainder = num.remainder(target).intValue();
            result.append(getSymbolFromNumber(remainder));
            num = num.divide(target);
        }

        return result.reverse().toString();
    }

    private static char getSymbolFromNumber(int number) {
        return number < 10
                ? (char) (number + '0')
                : (char) (number + 'W');
    }
}
