import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();
        long water = cups * 200;
        long milk = cups * 50;
        long cbeans = cups * 15;
        System.out.println("For " + cups + " of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(cbeans + " g of coffee beans");
    }
}
