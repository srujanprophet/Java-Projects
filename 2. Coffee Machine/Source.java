import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int total_water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int total_milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int total_cbeans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();
        int req_water = cups * 200;
        int req_milk = cups * 50;
        int req_cbeans = cups * 15;
        int w_a = total_water / 200;
        int m_a = total_milk / 50;
        int cb_a = total_cbeans / 15;
        int cups_a = (w_a < m_a) ? ( w_a < cb_a ? w_a : cb_a) : (m_a < cb_a ? m_a : cb_a);
        if(cups_a < cups) {
            System.out.println("No, I can make only " + cups_a + " cups(s) of coffee");
        }
        else if (cups_a > cups) {
            int extra = cups_a - cups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        }
        else System.out.println("Yes, I can make that amount of coffee");
    }
}

