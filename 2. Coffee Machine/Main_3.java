// 3. Estimate the Number of Servings

package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt()/200;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt()/50;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt()/15;
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int maxCups = water < milk ? (water < beans ? water : beans) : (milk < beans ? milk : beans);

        if (cups > maxCups) {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        } else if (cups < maxCups){
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that");
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }
}
