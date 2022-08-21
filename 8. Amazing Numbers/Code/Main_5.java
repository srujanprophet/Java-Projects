package numbers;

import java.util.*;

enum amazingNumbers {
    BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD
}

public class Main {

    static void printInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed");
        System.out.println("- two natural numbers and a property to search for");
        System.out.println("- separate the parameters with one space");
        System.out.println("- enter 0 to exit\n");

    }

    static boolean isEvenNumber(long n) {
        return (n % 2 == 0);
    }

    static boolean isOddNumber(long n) {
        return (n % 2 != 0);
    }

    static boolean isBuzzNumber(long n) {
        if (n % 7 == 0 && n % 10 == 7) {
            return true;
        } else if (n % 7 == 0) {
            return true;
        } else return n % 10 == 7;
    }

    static boolean isDuckNumber(long n) {
        while (n != 0) {
            if (n % 10 == 0) return true;
            n = n / 10;
        }
        return false;
    }

    static boolean isPalindromeNumber(long n) {
        long rev = 0;
        long x = n;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n = n / 10;
        }
        return (x == rev);
    }

    static boolean isGapful(String num) {
        if (num.length() < 3) {
            return false;
        }
        Integer n = (10 * Character.getNumericValue(num.charAt(0))) +
            Character.getNumericValue(num.charAt(num.length()-1));
        return (Long.parseLong(num) % n == 0);
    }

    static boolean isSpyNumber(Long n) {
        int sum = 0, prod = 1;
        while (n > 0) {
            sum += (n % 10);
            prod *= (n % 10);
            n = n/10;
        }
        return (sum == prod);
    }

    static String getMultipleProperties(Long n) {
        String buzz = "", duck = "", palindromic = "", gapful = "", spy = "", even = "", odd = "";
        if (isBuzzNumber(n)) buzz = "buzz, ";
        if (isDuckNumber(n)) duck = "duck, ";
        if (isPalindromeNumber(n)) palindromic = "palindromic, ";
        if (isGapful(Long.toString(n))) gapful = "gapful, ";
        if (isSpyNumber(n)) spy = "spy, ";
        if (isOddNumber(n)) odd = "odd";
        if (isEvenNumber(n)) even = "even";

        return String.format("\t\t%d is %s%s%s%s%s%s%s\n", n, buzz, duck, palindromic, gapful, spy, even, odd);
    }


    public static void main(String[] args) {
//        write your code here
        System.out.println("Welcome to Amazing Numbers!\n");
        printInstructions();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a request: ");
            String[] inputs = sc.nextLine().split(" ");
            Long n = Long.parseLong(inputs[0]);
            if (n < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                continue;
            } else if (n == 0) {
                System.out.println("\nGoodbye!");
                break;
            } else if (inputs.length == 2) {
                Integer range = Integer.parseInt(inputs[1]);
                if (range < 0) System.out.println("\n The second parameter should be a natural number.\n");
                for (Long i = n ; i < (n + range); i++) {
                    System.out.print(getMultipleProperties(i));
                }
                System.out.println();
            } else if (inputs.length == 3) {
                Integer range = Integer.parseInt(inputs[1]);
                boolean found = false;
                if (range < 0) System.out.println("\n The second parameter should be a natural number.\n");
                for (amazingNumbers number: amazingNumbers.values()) {
                    if (number.name().equalsIgnoreCase(inputs[2])) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("The property [%s] is wrong.\n", inputs[2].toUpperCase());
                    StringBuilder s = new StringBuilder();
                    for (amazingNumbers number: amazingNumbers.values()) {
                        s.append(number.name());
                        s.append(", ");
                    }
                    s.deleteCharAt(s.length()-1);
                    System.out.printf("Available properties: [%s]\n\n", s.toString());
                } else {
                    while (range != 0) {
                        String str = getMultipleProperties(n++);
                        if (str.contains(inputs[2].toLowerCase())) {
                            System.out.print(str);
                            range--;
                        }
                    }
                }
            } else {
                System.out.printf("Properties of %d\n", n);
                System.out.printf("\t\tbuzz: %b\n", isBuzzNumber(n));
                System.out.printf("\t\tduck: %b\n", isDuckNumber(n));
                System.out.printf(" palindromic: %b\n", isPalindromeNumber(n));
                System.out.printf("\t  gapful: %b\n", isGapful(inputs[0]));
                System.out.printf("\t\t spy: %b\n", isSpyNumber(n));
                System.out.printf("\t\teven: %b\n", isEvenNumber(n));
                System.out.printf("\t\t odd: %b\n\n", isOddNumber(n));
            }
        }
    }
}
