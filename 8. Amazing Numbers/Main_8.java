// 8. Happy and Sad Numbers

package numbers;

import java.util.*;

enum amazingNumbers {
    BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD, EVEN, ODD
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
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit\n");
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

    static boolean isJumpingNumber(String num) {
        if (num.length() == 1) return true;
        for (int i = 0; i < num.length() - 1; i++) {
            if (Math.abs(num.charAt(i) -
                    num.charAt(i + 1)) != 1) return false;
        }
        return true;
    }

    static boolean isHappy(Long n) {
        Long m = n;
        while (true) {
            long temp_sum = 0L;
            while (m != 0) {
                temp_sum += ((m%10) * (m%10));
                m /= 10;
            }
            if (temp_sum < 10L) {
                return temp_sum == 1L || temp_sum == 7L;
            }
            m = temp_sum;
        }
    }

    static String getMultipleProperties(Long n) {
        String buzz = "", duck = "", palindromic = "", gapful = "", spy = "",
                square = "", sunny = "", jumping = "", happy = "", sad = "",
                even = "", odd = "";
        if (isBuzzNumber(n)) buzz = "buzz, ";
        if (isDuckNumber(n)) duck = "duck, ";
        if (isPalindromeNumber(n)) palindromic = "palindromic, ";
        if (isGapful(Long.toString(n))) gapful = "gapful, ";
        if (isSpyNumber(n)) spy = "spy, ";
        if (isSquareNumber(n)) square = "square, ";
        if (isSunnyNumber(n)) sunny = "sunny, ";
        if (isJumpingNumber(Long.toString(n))) jumping = "jumping, ";
        if (isHappy(n)) happy = "happy, ";
        else sad = "sad, ";
        if (isOddNumber(n)) odd = "odd";
        else even = "even";

        return String.format("\t\t%d is %s%s%s%s%s%s%s%s%s%s%s%s\n", n, buzz, duck,
                palindromic, gapful, spy, square, sunny, jumping, happy, sad, even, odd);
    }

    static void printErrorProperty(ArrayList<String> properties) {
        if (properties.size() == 1) System.out.printf("\nThe property %s is wrong.\n", properties);
        else System.out.printf("\nThe properties %s are wrong.\n", properties);
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
            if (property.charAt(0) == '-') {
                if (number.name().equalsIgnoreCase(property.substring(1))) {
                    return true;
                }
            }
            else if (number.name().equalsIgnoreCase(property)) {
                return true;
            }
        }
        return found;
    }

    static boolean isMutuallyExclusive(ArrayList<String> properties) {
        if (properties.size() == 1) return true;
        ArrayList<String> pair1 = new ArrayList<>();
        ArrayList<String> pair2 = new ArrayList<>();
        ArrayList<String> pair3 = new ArrayList<>();
        ArrayList<String> pair4 = new ArrayList<>();
        ArrayList<String> pair5 = new ArrayList<>();

        pair1.add("even");
        pair1.add("odd");
        pair5.add("-even");
        pair5.add("-odd");
        pair2.add("duck");
        pair2.add("spy");
        pair3.add("sunny");
        pair3.add("square");
        pair4.add("happy");
        pair4.add("sad");

        String str1 = "", str2 = "";
        boolean flag = false;

        for (String property: properties) {
            if (properties.contains("-"+property)) {
                flag = true;
                str1 = property.toUpperCase();
                str2 = "-" + str1;
            }
        }

        if (properties.containsAll(pair1)) {
            str1 = "EVEN"; str2 = "ODD";
            flag = true;
        }
        if (properties.containsAll(pair2)) {
            str1 = "DUCK"; str2 = "SPY";
            flag = true;
        }
        if (properties.containsAll(pair3)) {
            str1 = "SUNNY"; str2 = "SQUARE";
            flag = true;
        }
        if (properties.containsAll(pair4)) {
            str1 = "SAD"; str2 = "HAPPY";
            flag = true;
        }
        if (properties.containsAll(pair5)) {
            str1 = "-EVEN"; str2 = "-ODD";
            flag = true;
        }
        if (flag) {
            System.out.printf("\nThe request contains mutually exclusive properties: [%s, %s]", str1, str2);
            System.out.println("\nThere are no numbers with these properties\n");
        }
        return flag;
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
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (n == 0) {
                System.out.println("\nGoodbye!");
                break;
            } else if (inputs.length == 2) {
                int range = Integer.parseInt(inputs[1]);
                if (range < 0) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                System.out.println();
                for (long i = n; i < (n + range); i++) {
                    System.out.print(getMultipleProperties(i));
                }
                System.out.println();
            } else if (inputs.length == 1) {
                System.out.printf("\nProperties of %d\n\n", n);
                System.out.printf("\t\tbuzz: %b\n", isBuzzNumber(n));
                System.out.printf("\t\tduck: %b\n", isDuckNumber(n));
                System.out.printf(" palindromic: %b\n", isPalindromeNumber(n));
                System.out.printf("\t  gapful: %b\n", isGapful(inputs[0]));
                System.out.printf("\t\t spy: %b\n", isSpyNumber(n));
                System.out.printf("\t  square: %b\n", isSquareNumber(n));
                System.out.printf("\t   sunny: %b\n", isSunnyNumber(n));
                System.out.printf("\t jumping: %b\n", isJumpingNumber(inputs[0]));
                System.out.printf("\t   happy: %b\n", isHappy(n));
                System.out.printf("\t\t sad: %b\n", !isHappy(n));
                System.out.printf("\t\teven: %b\n", !isOddNumber(n));
                System.out.printf("\t\t odd: %b\n\n", isOddNumber(n));
            } else {
                int range = Integer.parseInt(inputs[1]);
                if (range < 0) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                ArrayList<String> queries = new ArrayList<>(Arrays.asList(inputs).subList(2, inputs.length));
                if (queries.size() > 1 && isMutuallyExclusive(queries)) continue;
                boolean found = true;
                ArrayList<String> wrongProperties = new ArrayList<>();
                for (String query: queries) {
                    boolean curFound = isValidProperty(query);
                    if (!curFound) {
                        found = false;
                        wrongProperties.add(query.toUpperCase());
                    }
                }
                if (!found) {
                    printErrorProperty(wrongProperties);
                    continue;
                }
                ArrayList<String> includeQuery = new ArrayList<>();
                ArrayList<String> excludeQuery = new ArrayList<>();
                for (String query: queries) {
                    if (query.charAt(0) == '-') {
                        excludeQuery.add(query.substring(1));
                    } else includeQuery.add(query);
                }
                System.out.println();
                while (range != 0) {
                    String str = getMultipleProperties(n++);
                    boolean flag = true;
                    for (String query: includeQuery) {
                        if (!str.contains(query.toLowerCase())) {
                            flag = false;
                            break;
                        }
                    }
                    for (String query: excludeQuery) {
                        if (str.contains(query.toLowerCase())) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.print(str);
                        range--;
                    }
                }
                System.out.println();
            }
        }
    }
}
