import java.util.Scanner;

public class Source {
	static int water=400,milk=540,cbeans=120,cups=9,money=550;
	static Scanner sc = new Scanner(System.in);
    public static void stock(int water, int milk, int cbeans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(cbeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money\n");
    }

    public static void buy() {
    	System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = sc.nextInt();
        if (choice == 1) {
		    water -= 250;
		    cbeans -= 16;
		    money += 4;
		    cups--;
		}
		else if (choice == 2) {
		    water -= 350;
		    milk -= 75;
		    cbeans -= 20;
		    money += 7;
		    cups--;
	    }
	    else {
		    water -= 200;
		    milk -= 100;
		    cbeans -= 12;
		    money += 6;
		    cups--;
	    }
	    System.out.println();
	    stock(water, milk, cbeans, cups, money);
    }

    public static void fill() {
    	System.out.println("Write how many ml of water do you want to add:");
		int wn = sc.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		int mn = sc.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add:");
		int cbn = sc.nextInt();
		System.out.println("Write how many disposable cups of coffee  do you want to add:");
		int cn = sc.nextInt();
		water += wn;
		cbeans += cbn;
		milk += mn;
		cups += cn;
		System.out.println();
		stock(water, milk, cbeans, cups, money);
    }

    public static void take() {
    	money = 0;
    	System.out.println();
		stock(water, milk, cbeans, cups, money);
    }

    public static void main(String[] args) {
        stock(water, milk, cbeans, cups, money);
        System.out.println("Write action (buy, fill, take):");
        String action = sc.next();
        if (action.equals("buy")) {
            buy();
	    }
	    else if (action.equals("fill")) {
	    	fill();
	   	}
	   	else take();
    }
}
