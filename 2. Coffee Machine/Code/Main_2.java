// 2. Ingredient Calculator

package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int water = 200 , milk = 50 , beans = 15;
        int cups = scanner.nextInt();
        System.out.printf(
                "For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans",
                cups,cups * water, cups * milk, cups * beans);
    }
}
