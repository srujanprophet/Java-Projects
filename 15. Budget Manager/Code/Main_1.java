package budget;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> itemList = new ArrayList<>();
        double total_price = 0;
        System.out.print(" ");
        while (sc.hasNext()) {
            itemList.add(sc.nextLine());
            System.out.print(" ");
        }
        for (String item: itemList) {
            String[] item_info = item.split(" ");
            double price = Double.parseDouble(item_info[item_info.length-1].substring(1));
            total_price += price;
            System.out.println(item);
        }
        System.out.printf("\nTotal: $%.2f \n", total_price);
    }
}
