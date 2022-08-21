// 2. Make a Menu

package budget;


import java.util.*;

public class Main {

    static double balance = 0d;
    static Scanner sc = new Scanner(System.in);
    static LinkedHashMap<String, Double> purchases = new LinkedHashMap<>();

    static void addIncome() {
        System.out.println("\nEnter income:");
        double income = sc.nextDouble();
        balance += income;
        System.out.println("Income was added!\n");
    }

    static void addPurchase() {
        sc.nextLine();
        System.out.println("\nEnter purchase name: ");
        String pName = sc.nextLine();
        System.out.println("Enter its price: ");
        double price = sc.nextDouble();
        purchases.put(pName, price);
        balance -= price;
        System.out.println("Purchase was added!\n");
    }

    static void showPurchases() {
        System.out.println();
        double total_sum = 0;
        for (var entry: purchases.entrySet()) {
            System.out.printf("%s $%.2f\n", entry.getKey(), entry.getValue());
            total_sum += entry.getValue();
        }
        if (purchases.size() == 0) System.out.println("The purchase list is empty\n");
        else System.out.printf("Total sum: $%.2f\n\n", total_sum);
    }

    static void showBalance() {
        if (balance < 0) balance = 0;
        System.out.printf("\nBalance: $%.2f \n\n", balance);
    }

    public static void main(String[] args) {
        // write your code here
        int choice;
        do {
            System.out.println("Choose your action:\n1) Add income\n2) Add purchase\n" +
                    "3) Show list of purchases\n4) Balance\n0) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addIncome(); break;
                case 2: addPurchase(); break;
                case 3: showPurchases(); break;
                case 4: showBalance(); break;
                case 0: System.out.println("\nBye!");
            }
        } while (choice != 0);
    }
}
