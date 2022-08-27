// 2. Create a Menu

package contacts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
    private String name;
    private String surname;
    private String phone;

    Record() {}

    private boolean isValidPhone(String phone) {
        String p1 = "\\+?[\\da-zA-Z]+([-\\s]?[a-zA-Z\\d]{2,})*"; // No parentheses
        String p2 = "\\+?\\([\\dA-Za-z]+\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 1st group parentheses
        String p3 = "\\+?[\\dA-Za-z]+[-\\s]\\([\\dA-Za-z]{2,}\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 2nd group parentheses

        Matcher m1 = Pattern.compile(p1).matcher(phone);
        Matcher m2 = Pattern.compile(p2).matcher(phone);
        Matcher m3 = Pattern.compile(p3).matcher(phone);

        return (m1.matches() || m2.matches() || m3.matches());
    }

    public Record setPhone(String phone) {
        if (isValidPhone(phone)) this.phone = phone;
        else {
            System.out.println("Wrong number format!");
            this.phone = "";
        }
        return this;
    }

    public String getPhone() { return this.phone; }

    public Record setName(String name) { this.name = name; return this; }

    public String getName() { return this.name; }

    public Record setSurname(String surname) { this.surname = surname; return this; }

    public String getSurname() { return this.surname; }

    public boolean hasNumber() { return this.phone.length() != 0; }

    public String toString() {
        return String.format(" %s %s, %s", this.name, this.surname,
                (this.phone.isEmpty()?"[no number]":this.phone));
    }
}

class App {

    ArrayList<Record> records = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addRecord() {
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter the surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter the number: ");
        String phone = sc.nextLine();
        Record rec = new Record()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone);
        records.add(rec);
        System.out.println("The record added.");
    }

    public void countRecords() {
        System.out.printf("The Phone Book has %d records.\n", records.size());
    }

    public void editRecord() {
        if (records.isEmpty()) System.out.println("No records to edit!");
        else {
            this.listRecords();
            System.out.print("Select a record: ");
            int idx = Integer.parseInt(sc.nextLine());
            Record updateRec = records.get(idx - 1);
            System.out.print("Select a field (name, surname, number): ");
            String field = sc.nextLine();
            if (field.equalsIgnoreCase("name")) {
                System.out.print("Enter name: ");
                updateRec.setName(sc.nextLine());
            } else if (field.equalsIgnoreCase("surname")) {
                System.out.print("Enter surname: ");
                updateRec.setSurname(sc.nextLine());
            } else if (field.equalsIgnoreCase("number")) {
                System.out.print("Enter number: ");
                updateRec.setPhone(sc.nextLine());
            } else System.out.println("ERROR : Invalid Field!");
            System.out.println("The record updated!");
        }
    }

    public void removeRecord() {
        if (records.isEmpty()) System.out.println("No records to remove!");
        else {
            this.listRecords();
            System.out.print("Select a record: ");
            int idx = Integer.parseInt(sc.nextLine());
            records.remove(idx - 1);
            System.out.println("The record removed!");
        }
    }

    public void listRecords() {
        for (int i = 1; i <= records.size(); i++) {
            System.out.println(i + "." + records.get(i-1));
        }
    }


}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            String action = sc.next();
            if (action.equalsIgnoreCase("exit")) break;
            else if (action.equalsIgnoreCase("add")) app.addRecord();
            else if (action.equalsIgnoreCase("remove")) app.removeRecord();
            else if (action.equalsIgnoreCase("edit")) app.editRecord();
            else if (action.equalsIgnoreCase("count")) app.countRecords();
            else if (action.equalsIgnoreCase("list")) app.listRecords();
            else System.out.println("ERROR : Invalid Command!");
        }
    }
}
