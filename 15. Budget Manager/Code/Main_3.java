// 3. Oh The Things You Can Buy

package budget;


import java.util.*;

class Purchase {
    UUID id;
    String name;
    double price;
    String category;

    Purchase(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = UUID.randomUUID();
    }

    public UUID getId() { return id; }
    public double getPrice() { return price; }
    public String getName() { return name; }
    public String getCategory() { return category; }
}

public class Main {

    static double balance = 0d;
    static Scanner sc = new Scanner(System.in);
    static LinkedHashMap<UUID, Purchase> purchases = new LinkedHashMap<>();

    static void addIncome() {
        System.out.println("\nEnter income:");
        double income = sc.nextDouble();
        balance += income;
        System.out.println("Income was added!\n");
    }

    static void addPurchase() {
        int choice;
        while (true) {
            System.out.println("\nChoose the type of purchase\n1) Food\n2) Clothes\n3) Entertainment\n" +
                    "4) Other\n5) Back");
            String category = "";
            choice = sc.nextInt();
            switch (choice) {
                case 1: category = "Food"; break;
                case 2: category = "Clothes"; break;
                case 3: category = "Entertainment"; break;
                case 4: category = "Other"; break;
                case 5: return;
            }
            sc.nextLine();
            System.out.println("\nEnter purchase name:");
            String name = sc.nextLine();
            System.out.println("Enter its price:");
            double price = sc.nextDouble();
            Purchase p = new Purchase(name, price, category);
            purchases.put(p.getId(), p);
            balance -= price;
            System.out.println("Purchase was added!");
        }
    }


    static void showPurchases() {
        if (purchases.size() == 0) {
            System.out.println("\nThe purchase list is empty!\n"); return;
        }

        int choice;
        while (true) {
            System.out.println("\nChoose the type of purchase\n1) Food\n2) Clothes\n3) Entertainment\n" +
                    "4) Other\n5) All\n6) Back");
            choice = sc.nextInt();
            String category = "";
            switch (choice) {
                case 1: category = "Food"; break;
                case 2: category = "Clothes"; break;
                case 3: category = "Entertainment"; break;
                case 4: category = "Other"; break;
                case 5: category = "All"; break;
                case 6: return;
            }

            double total_sum = 0d;
            System.out.println("\n" + category + ":");
            for (Purchase p: purchases.values()) {
                if (p.getCategory().equals(category) || category.equals("All")) {
                    System.out.printf("%s $%.2f\n", p.getName(), p.getPrice());
                    total_sum += p.getPrice();
                }
            }
            if (total_sum == 0) System.out.println("The purchase list is empty!\n");
            else System.out.printf("Total sum: $%.2f\n", total_sum);

        }
    }

    static void showBalance() {
        if (balance < 0) balance = 0;
        System.out.printf("\nBalance: $%.2f \n\n", balance);
    }

    public static void main(String[] args) {
        // write your code here
        int choice;
        do {
            System.out.println("\nChoose your action:\n1) Add income\n2) Add purchase\n" +
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
