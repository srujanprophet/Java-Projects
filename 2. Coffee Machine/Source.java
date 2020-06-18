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
    	System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = sc.next();
        if (choice.equals("back")) {
        	System.out.println();
        	return;
        }
        if (cups == 0) {
        	System.out.println("Sorry, not enough cups!\n");
        	return;
        }
        if (choice.equals("1")) {
        	if (water < 250) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (cbeans < 16) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee!\n");
		    water -= 250;
		    cbeans -= 16;
		    money += 4;
		    cups--;
		}
		else if (choice.equals("2")) {
			if (water < 350) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (cbeans < 20) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	if (milk < 75) {
        		System.out.println("Sorry, not enough milk!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee!\n");
		    water -= 350;
		    milk -= 75;
		    cbeans -= 20;
		    money += 7;
		    cups--;
	    }
	    else {
	    	if (water < 200) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (cbeans < 100) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	if (milk < 12) {
        		System.out.println("Sorry, not enough milk!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee\n");
		    water -= 200;
		    milk -= 100;
		    cbeans -= 12;
		    money += 6;
		    cups--;
	    }
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
    }

    public static void take() {
    	System.out.println("I gave you $" + money);
    	System.out.println();
    	money = 0;
    }

    public static void main(String[] args) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.next();
        while (!action.equals("exit")) {
        	if (action.equals("buy")) {
            	buy();
	    	}
	    	else if (action.equals("fill")) {
	    		fill();
	   		}
	   		else if (action.equals("remaining")) {
	   			System.out.println();
				stock(water, milk, cbeans, cups, money);
	   		}
	   		else take();
	   		System.out.println("Write action (buy, fill, take, remaining, exit):");
        	action = sc.next();
	   	}
    }
}
