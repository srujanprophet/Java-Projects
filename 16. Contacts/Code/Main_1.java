// 1. First Contact

package contacts;

import java.util.Scanner;

class Record {
    String name;
    String surname;
    String phone;

    Record(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        System.out.println("A record created!");
    }
}

class App {
    void addRecord() {
        System.out.println("Enter the name of the person:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Enter the surname of the person:");
        String surname = sc.next();
        System.out.println("Enter the number:");
        String phone = sc.next();
        Record rec = new Record(name, surname, phone);
        System.out.println("A Phone Book with a single record created!");
    }
}

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.addRecord();
    }
}
