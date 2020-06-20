import java.util.Scanner;

public class Source {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CoffeeMachine c_m = new CoffeeMachine(400, 540, 120, 9, 550);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.next();
        while (!action.equals("exit")) {
        	c_m.perform(action);
	   		System.out.println("Write action (buy, fill, take, remaining, exit):");
        	action = sc.next();
	   	}
    }
}   

class CoffeeMachine {
	static Scanner sc = new Scanner(System.in);
	int water,milk,cbeans,cups,money;
	public CoffeeMachine(int water, int milk, int cbeans, int cups, int money) {
		this.water = water;
		this.milk = milk;
		this.cbeans = cbeans;
		this.cups = cups;
		this.money = money;
	}

	public void stock() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.cbeans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money\n");
    }

    public void buy() {
    	System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = sc.next();
        if (choice.equals("back")) {
        	System.out.println();
        	return;
        }
        if (this.cups == 0) {
        	System.out.println("Sorry, not enough cups!\n");
        	return;
        }
        if (choice.equals("1")) {
        	if (this.water < 250) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (this.cbeans < 16) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee!\n");
		    this.water -= 250;
		    this.cbeans -= 16;
		    this.money += 4;
		    this.cups--;
		}
		else if (choice.equals("2")) {
			if (this.water < 350) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (this.cbeans < 20) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	if (this.milk < 75) {
        		System.out.println("Sorry, not enough milk!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee!\n");
		    this.water -= 350;
		    this.milk -= 75;
		    this.cbeans -= 20;
		    this.money += 7;
		    this.cups--;
	    }
	    else {
	    	if (this.water < 200) {
        		System.out.println("Sorry, not enough water!\n");
        		return;
        	}
        	if (this.cbeans < 100) {
        		System.out.println("Sorry, not enough coffee beans!\n");
        		return;
        	}
        	if (this.milk < 12) {
        		System.out.println("Sorry, not enough milk!\n");
        		return;
        	}
        	System.out.println("I have enough resources, making you a coffee\n");
		    this.water -= 200;
		    this.milk -= 100;
		    this.cbeans -= 12;
		    this.money += 6;
		    this.cups--;
	    }
    }

    public void fill() {
    	System.out.println("\nWrite how many ml of water do you want to add:");
		int wn = sc.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		int mn = sc.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add:");
		int cbn = sc.nextInt();
		System.out.println("Write how many disposable cups of coffee  do you want to add:");
		int cn = sc.nextInt();
		this.water += wn;
		this.cbeans += cbn;
		this.milk += mn;
		this.cups += cn;
		System.out.println();
    }

    public void take() {
    	System.out.println("\nI gave you $" + this.money);
    	System.out.println();
    	this.money = 0;
    }

    public void perform(String action) {
    	if (action.equals("remaining")) {
    		this.stock();
    	}
    	else if (action.equals("buy")) {
    		this.buy();
    	}
    	else if (action.equals("fill")) {
    		this.fill();
    	}
    	else if(action.equals("take")) {
    		this.take();
    	}
    	else return;
    }
}
