// 6. Sunny and Square Numbers

package numbers;

import java.util.*;

enum amazingNumbers {
    BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD
}

public class Main {

    static void printInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the " +
                "properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many " +
                "consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
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
        int n = (10 * Character.getNumericValue(num.charAt(0))) +
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

    static boolean isSquareNumber(Long n) {
        long sr = (long) Math.sqrt(n.doubleValue());
        return (sr * sr == n);
    }

    static boolean isSunnyNumber(Long n) {
        return isSquareNumber(n+1);
    }

    static String getMultipleProperties(Long n) {
        String buzz = "", duck = "", palindromic = "", gapful = "", spy = "",
                square = "", sunny = "", even = "", odd = "";
        if (isBuzzNumber(n)) buzz = "buzz, ";
        if (isDuckNumber(n)) duck = "duck, ";
        if (isPalindromeNumber(n)) palindromic = "palindromic, ";
        if (isGapful(Long.toString(n))) gapful = "gapful, ";
        if (isSpyNumber(n)) spy = "spy, ";
        if (isSquareNumber(n)) square = "square, ";
        if (isSunnyNumber(n)) sunny = "sunny, ";
        if (isOddNumber(n)) odd = "odd";
        if (isEvenNumber(n)) even = "even";

        return String.format("\t\t%d is %s%s%s%s%s%s%s%s%s\n", n, buzz, duck,
                palindromic, gapful, spy, square, sunny, even, odd);
    }

    static void printErrorProperty(String property) {
        System.out.printf("\nThe property [%s] is wrong.\n", property);
        StringBuilder s = new StringBuilder();
        for (amazingNumbers number: amazingNumbers.values()) {
            s.append(number.name());
            s.append(", ");
        }
        s.deleteCharAt(s.length()-1);
        s.deleteCharAt(s.length()-1);
        System.out.printf("Available properties: [%s]\n\n", s);
    }

    static void printErrorProperty(String property1, String property2) {
        System.out.printf("\nThe properties [%s, %s] are wrong.\n", property1, property2);
        StringBuilder s = new StringBuilder();
        for (amazingNumbers number: amazingNumbers.values()) {
            s.append(number.name());
            s.append(", ");
        }
        s.deleteCharAt(s.length()-1);
        s.deleteCharAt(s.length()-1);
        System.out.printf("Available properties: [%s]\n\n", s);
    }

    static boolean isValidProperty(String property) {
        boolean found = false;
        for (amazingNumbers number: amazingNumbers.values()) {
            if (number.name().equalsIgnoreCase(property)) {
                return true;
            }
        }
        return found;
    }

    static boolean isMutuallyExclusive(String prop1, String prop2) {
        String[] pair1 = {"EVEN", "ODD"};
        String[] pair2 = {"DUCK", "SPY"};
        String[] pair3 = {"SUNNY", "SQUARE"};
        String[] inputPair = {prop1, prop2};
        HashSet<String> hs1 = new HashSet<>(Arrays.asList(pair1));
        HashSet<String> hs2 = new HashSet<>(Arrays.asList(pair2));
        HashSet<String> hs3 = new HashSet<>(Arrays.asList(pair3));
        HashSet<String> inputHS = new HashSet<>(Arrays.asList(inputPair));
        ArrayList<HashSet<String>> mE_Pairs = new ArrayList<>();
        mE_Pairs.add(hs1);
        mE_Pairs.add(hs2);
        mE_Pairs.add(hs3);

        for (HashSet<String> hs : mE_Pairs) {
            if (hs.equals(inputHS)) {
                System.out.printf("\nThe request contains mutually exclusive properties: [%s, %s]\n",
                        prop2, prop1);
                System.out.println("There are no numbers with these properties.\n");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        write your code here
        System.out.println("Welcome to Amazing Numbers!\n");
        printInstructions();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a request: ");
            String[] inputs = sc.nextLine().split(" ");
            long n = Long.parseLong(inputs[0]);
            if (n < 0) {
                System.out.println("""

                        The first parameter should be a natural number or zero.
                        """);
            } else if (n == 0) {
                System.out.println("\nGoodbye!");
                break;
            } else if (inputs.length >= 2) {
                int range = Integer.parseInt(inputs[1]);
                if (range < 0) {
                    System.out.println("""

                             The second parameter should be a natural number.
                            """);
                    continue;
                }
                boolean found = true;
                int ctr = 0, idx = 0;
                for (int i = 2; i <= inputs.length - 1; i++) {
                    boolean curFound = isValidProperty(inputs[i]);
                    if (!curFound) {
                        found = false;
                        ctr++;
                        idx = i;
                    }
                }
                if (!found) {
                    if (ctr == 2) printErrorProperty(inputs[2].toUpperCase(),
                            inputs[3].toUpperCase());
                    else if (ctr == 1) {
                        printErrorProperty(inputs[idx].toUpperCase());
                    }
                    continue;
                }
                if (inputs.length == 2) {
                    for (long i = n; i < (n + range); i++) {
                        System.out.print(getMultipleProperties(i));
                    }
                    System.out.println();
                } else if (inputs.length == 3) {
                    System.out.println();
                    while (range != 0) {
                        String str = getMultipleProperties(n++);
                        if (str.contains(inputs[2].toLowerCase())) {
                            System.out.print(str);
                            range--;
                        }
                    }
                    System.out.println();
                } if (inputs.length == 4) {
                    if (isMutuallyExclusive(inputs[2].toUpperCase(),
                            inputs[3].toUpperCase())) continue;
                    System.out.println();
                    while (range != 0) {
                        String str = getMultipleProperties(n++);
                        if (str.contains(inputs[2].toLowerCase())
                                && str.contains(inputs[3].toLowerCase())) {
                            System.out.print(str);
                            range--;
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.printf("Properties of %d\n", n);
                System.out.printf("\t\tbuzz: %b\n", isBuzzNumber(n));
                System.out.printf("\t\tduck: %b\n", isDuckNumber(n));
                System.out.printf(" palindromic: %b\n", isPalindromeNumber(n));
                System.out.printf("\t  gapful: %b\n", isGapful(inputs[0]));
                System.out.printf("\t\t spy: %b\n", isSpyNumber(n));
                System.out.printf("\t  square: %b\n", isSquareNumber(n));
                System.out.printf("\t   sunny: %b\n", isSunnyNumber(n));
                System.out.printf("\t\teven: %b\n", isEvenNumber(n));
                System.out.printf("\t\t odd: %b\n\n", isOddNumber(n));
            }
        }
    }
}
