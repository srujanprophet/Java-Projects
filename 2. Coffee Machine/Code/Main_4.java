// 4. Buy, Fill, Take

package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static  int  water = 400,
            milk = 540 ,
            beans  = 120 ,
            disCups = 9,
            money = 550 ;

    static  String action;
    public static void main(String[] args) {
        state();
        
        System.out.println("Write action (buy, fill, take):");
        action = scanner.nextLine();

        switch (action){
            case "buy" :
                buy();
                break;

            case  "fill":
                fill();
                break;

            case "take" :
                take();
                break;
        }
    }

    public static void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int userInput = scanner.nextInt();
        if (userInput == 1 ){
            water -= 250;
            beans -= 16;
            money += 4;
            disCups -= 1;
            state();
        }else if (userInput == 2){
            water -= 350;
            milk -= 75;
            beans -= 20;
            money += 7;
            disCups -= 1;

            state();
        }else if (userInput == 3){
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
            disCups -= 1;
            state();
        }
    }
    public  static void fill(){
        int userInput;
        System.out.println("Write how many ml of water you want to add: ");
        userInput = scanner.nextInt();
        water += userInput;

        System.out.println("Write how many ml of milk you want to add:");
        userInput = scanner.nextInt();
        milk += userInput;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        userInput = scanner.nextInt();
        beans += userInput;

        System.out.println("Write how many disposable cups of coffee you want to add:");
        userInput = scanner.nextInt();
        disCups += userInput;
        state();
    }
    public  static void take(){
        System.out.printf("I gave you  $%d \n",money);
        money = 0;
        state();
    }

    public static void state(){
        System.out.printf(
                "\nThe coffee machine has:\n" +
                        "%d ml of water\n" +
                        "%d ml of milk\n" +
                        "%d g of coffee beans\n" +
                        "%d disposable cups\n" +
                        "$%d of money\n",water,milk,beans,disCups,money);
    }
}
