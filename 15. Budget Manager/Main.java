package budget;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

class sortByPrice implements Comparator<Purchase> {
    public int compare(Purchase p1, Purchase p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
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

    static void save() {
        File file = new File("purchases.txt");
        try { file.createNewFile(); }
        catch (IOException e) { System.out.println("Error " + e.getMessage()); }

        try (FileWriter f = new FileWriter(file)) {
            for (Purchase p : purchases.values()) {
                f.write(String.format("%s,%.2f,%s\n",
                        p.getName(), p.getPrice(), p.getCategory()));
            }
            f.write(String.format("%f", balance));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nPurchases were saved!");
    }

    static void load() {
        File file = new File("purchases.txt");
        try (Scanner f = new Scanner(file)) {
            while (f.hasNext()) {
                String[] item = f.nextLine().split(",");
                if (item.length == 1) balance = Double.parseDouble(item[0]);
                else {
                    Purchase p = new Purchase(item[0], Double.parseDouble(item[1]), item[2]);
                    purchases.put(p.getId(), p);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }

        System.out.println("\nPurchases were loaded!");
    }


    static void sortAllPurchases() {
        if (purchases.isEmpty()) {
            System.out.println("\nThe purchase list is empty!"); return;
        }
        ArrayList<Purchase> sortedList = new ArrayList<>(purchases.values());
        sortedList.sort(new sortByPrice());

        double total = 0d;
        System.out.println("\nAll:");
        for (Purchase p: sortedList) {
            System.out.printf("%s $%.2f\n", p.getName(), p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    static int getIdxFromCat(String category) {
        int idx = 0;
        switch (category) {
            case "Food" : idx = 1; break;
            case "Clothes": idx = 2; break;
            case "Entertainment": idx = 3; break;
            case "Other": idx = 4; break;
        }
        return idx;
    }

    static String getCatFromIdx(int idx) {
        String category = "";
        switch (idx) {
            case 1: category = "Food"; break;
            case 2: category = "Clothes"; break;
            case 3: category = "Entertainment"; break;
            case 4: category = "Other"; break;
        }
        return category;
    }

    static void sortByType() {
        TreeMap<Integer, Double> typeCosts = new TreeMap<>();
        typeCosts.put(1, 0d); typeCosts.put(2, 0d);
        typeCosts.put(3, 0d); typeCosts.put(4, 0d);

        for (Purchase p: purchases.values()) {
            int idx = getIdxFromCat(p.getCategory());
            typeCosts.put(idx, typeCosts.get(idx) + p.getPrice());
        }

        List<Map.Entry<Integer, Double>> list = new LinkedList<>(typeCosts.entrySet());
        list.sort( (l1, l2) -> Double.compare(l2.getValue(), l1.getValue()));

        System.out.println("\nTypes:");
        for(var entry: list) System.out.printf("%s - $%.2f\n",
                getCatFromIdx(entry.getKey()), entry.getValue());
        double total_sum = typeCosts.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.printf("Total sum: $%.2f\n", total_sum);
    }

    static void sortByCertainType() {
        System.out.println("\nChoose the type of purchase:\n1) Food\n2) Clothes\n3) Entertainment\n4) Other");
        String category = "";
        int choice = sc.nextInt();
        double total_sum = 0d;
        switch (choice) {
            case 1: category = "Food"; break;
            case 2: category = "Clothes"; break;
            case 3: category = "Entertainment"; break;
            case 4: category = "Other"; break;
        }
        List<Purchase> typePurchase = new LinkedList<>();
        for (Purchase p: purchases.values()) {
            if (p.getCategory().equals(category)) typePurchase.add(p);
        }

        if (typePurchase.isEmpty()) {
            System.out.println("\nThe purchase list is empty!\n"); return;
        }

        typePurchase.sort(new sortByPrice());
        System.out.print("\n" + category + ":");
        for (Purchase p: typePurchase) {
            System.out.printf("\n%s $%.2f", p.getName(), p.getPrice());
            total_sum += p.getPrice();
        }
        System.out.printf("\nTotal sum: $%.2f\n", total_sum);
    }

    static void analyze() {
        while (true) {
            System.out.println("\nHow do you want to sort?\n1. Sort all purchases\n2. Sort by type\n" +
                    "3. Sort certain type\n4. Back");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: sortAllPurchases(); break;
                case 2: sortByType(); break;
                case 3: sortByCertainType(); break;
                case 4: return;
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        int choice;
        do {
            System.out.println("\nChoose your action:\n1) Add income\n2) Add purchase\n" +
                    "3) Show list of purchases\n4) Balance\n5) Save\n6) Load\n7) Analyze (Sort)\n0) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addIncome(); break;
                case 2: addPurchase(); break;
                case 3: showPurchases(); break;
                case 4: showBalance(); break;
                case 5: save(); break;
                case 6: load(); break;
                case 7: analyze(); break;
                case 0: System.out.println("\nBye!");
            }
        } while (choice != 0);
    }
}
