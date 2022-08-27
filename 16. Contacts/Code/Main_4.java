// 4. Searching

package contacts;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Record {
    public String name;
    public String number;
    LocalDateTime createTime;
    LocalDateTime lastEditTime;

    abstract Field[] fieldsList();
    abstract void setField(String s, String val);
    abstract Object getValue(String s);

    abstract String getMenuName();


    Record() {
        this.createTime = LocalDateTime.now();
        this.lastEditTime = LocalDateTime.now();
    }
    private boolean isValidPhone(String number) {
        String p1 = "\\+?[\\da-zA-Z]+([-\\s]?[a-zA-Z\\d]{2,})*"; // No parentheses
        String p2 = "\\+?\\([\\dA-Za-z]+\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 1st group parentheses
        String p3 = "\\+?[\\dA-Za-z]+[-\\s]\\([\\dA-Za-z]{2,}\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 2nd group parentheses

        Matcher m1 = Pattern.compile(p1).matcher(number);
        Matcher m2 = Pattern.compile(p2).matcher(number);
        Matcher m3 = Pattern.compile(p3).matcher(number);

        return (m1.matches() || m2.matches() || m3.matches());
    }

    public void setPhoneNumber(String number) {
        if (isValidPhone(number)) this.number = number;
        else {
            System.out.println("Wrong number format!");
            this.number = "";
        }
    }

    public String getPhoneNumber() { return this.number; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public boolean hasNumber() { return this.number.length() != 0; }

    public void updateLastEdit() { this.lastEditTime = LocalDateTime.now(); }
}

class PersonRecord extends Record {
    public String surname;
    public String birthDate;
    public String gender;

    PersonRecord() {
        this.birthDate = "";
        this.gender = "";
        this.addPerson();
    }

    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        this.setField("name", sc.nextLine());
        System.out.print("Enter the surname: ");
        this.setField("surname", sc.nextLine());
        System.out.print("Enter the birth date: ");
        this.setField("birth", sc.nextLine());
        System.out.print("Enter the gender (M, F): ");
        this.setField("gender", sc.nextLine());
        System.out.print("Enter the number: ");
        this.setField("number", sc.nextLine());
    }

    public Field[] fieldsList() { return this.getClass().getFields(); }

    public void setField(String s, String val) {
        switch(s) {
            case "name": this.setName(val); break;
            case "surname": this.setSurname(val); break;
            case "birth": this.setBirthDate(val); break;
            case "gender": this.setGender(val); break;
            case "number": this.setPhoneNumber(val); break;
            default: System.out.println("Invalid field for person");
        }
    }

    public String getValue(String s) {
        switch(s) {
            case "name": return this.getName();
            case "surname": return  this.getSurname();
            case "birth": return this.getBirthDate();
            case "gender": return this.getGender();
            case "number": return this.getPhoneNumber();
            default: return "Invalid field for person";
        }
    }

    public String getMenuName() {
        return (this.getName() + " " + this.getSurname());
    }
    void setSurname(String surname) { this.surname = surname; }

    String getSurname() { return this.surname; }

    void setBirthDate(String birthDate) {
        if (birthDate.isEmpty()) System.out.println("Bad birth date!");
        else this.birthDate = birthDate;
    }

    String getBirthDate() { return this.birthDate; }

    void setGender(String gender) {
        if (gender.equals("F") || gender.equals("M")) this.gender = gender;
        else System.out.println("Bad gender!");
    }

    String getGender() { return this.gender; }

    public String toString() {
        return String.format("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\nNumber: %s\n" +
                "Time created: %s\nTime last edit: %s\n", this.name, this.surname,
                (this.birthDate.isEmpty() ? "[no data]":this.birthDate),
                (this.gender.isEmpty() ? "[no data]":this.gender), this.number,
                this.createTime.truncatedTo(ChronoUnit.SECONDS),
                this.lastEditTime.truncatedTo(ChronoUnit.SECONDS));
    }
}

// TODO : Serialization and Deserialization of Records

class OrganizationRecord extends Record {

    public String address;

    OrganizationRecord() {
        this.addOrganization();
    }

    void addOrganization() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the organization name: ");
        this.setField("name", sc.nextLine());
        System.out.print("Enter the address: ");
        this.setField("address", sc.nextLine());
        System.out.print("Enter the number: ");
        this.setField("number", sc.nextLine());
    }

    public Field[] fieldsList() { return this.getClass().getFields(); }

    public void setField(String s, String val) {
        switch(s) {
            case "name": this.setName(val); break;
            case "address": this.setAddress(val); break;
            case "number": this.setPhoneNumber(val); break;
            default: System.out.println("Invalid field for organization");
        }
    }

    public String getMenuName() {
        return this.getName();
    }

    String getValue(String s) {
        switch(s) {
            case "name": return this.getName();
            case "address": return this.getAddress();
            case "number": return this.getPhoneNumber();
            default: return "Invalid field for organization";
        }
    }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return this.address; }

    public String toString() {
        return String.format("Organization name: %s\nAddress: %s\nNumber: %s\nTime created: %s" +
                "\nTime last edit: %s\n", this.name, this.address, this.number,
                this.createTime.truncatedTo(ChronoUnit.MINUTES),
                this.lastEditTime.truncatedTo(ChronoUnit.MINUTES));
    }
}

class App {

    ArrayList<Record> records = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addRecord() {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        if (type.equalsIgnoreCase("person")) records.add(new PersonRecord());
        else if (type.equalsIgnoreCase("organization")) records.add(new OrganizationRecord());
        else System.out.println("Invalid type\n");
        System.out.print("The record added.\n");
    }

    public void countRecords() {
        System.out.printf("The Phone Book has %d records.\n", records.size());
    }

    public void editRecord(Record updateRec) {
        if (records.isEmpty()) System.out.println("No records to edit!");
        else {
            StringBuilder fieldNames = new StringBuilder();
            for (Field f : updateRec.fieldsList()) fieldNames.append(f.getName()).append(", ");
            for (int i = 0; i < 2; i++) fieldNames.deleteCharAt(fieldNames.length() - 1);
            System.out.printf("Select a field (%s): ", fieldNames); String field = sc.nextLine();
            System.out.printf("Enter %s: ", field); String val = sc.nextLine();
            updateRec.setField(field, val); updateRec.updateLastEdit();
            System.out.println("Saved");
            System.out.println(updateRec);
        }
    }

    public void searchRecord() {
        while (true) {
            System.out.print("Enter search query: ");
            String searchText = sc.nextLine().toUpperCase();
            ArrayList<Record> searchResults = new ArrayList<>();
            for (Record r : records) {
                if (r.getMenuName().toUpperCase().contains(searchText)) searchResults.add(r);
                else if (r.getPhoneNumber().contains(searchText)) searchResults.add(r);
            }
            System.out.printf("Found %d results:\n", searchResults.size());
            for (int i = 1; i <= searchResults.size(); i++) {
                System.out.println(i + ". " + searchResults.get(i - 1).getMenuName());
            }
            System.out.print("\n[search] Enter action ([number], back, again): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) break;
            else if (input.equalsIgnoreCase("again")) { }
            else { recordMenu(Integer.parseInt(input) - 1); break; }
        }
    }

    public void listRecords() {
        for (int i = 1; i <= records.size(); i++) {
            System.out.println(i + ". " + records.get(i - 1).getMenuName());
        }
        while (true) {
            System.out.print("\n[list] Enter action ([number], back): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) break;
            else { recordMenu(Integer.parseInt(input) - 1); break; }
        }
    }

    public void recordMenu(int idx) {
        Record rec = records.get(idx);
        System.out.println(rec);
        while (true) {
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("menu")) break;
            else if (input.equalsIgnoreCase("delete")) records.remove(idx);
            else if (input.equalsIgnoreCase("edit")) editRecord(rec);
            else System.out.println("Error: incorrect input");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String action = sc.next();
            if (action.equalsIgnoreCase("exit")) break;
            else if (action.equalsIgnoreCase("add")) app.addRecord();
            else if (action.equalsIgnoreCase("search")) app.searchRecord();
            else if (action.equalsIgnoreCase("list")) app.listRecords();
            else if (action.equalsIgnoreCase("count")) app.countRecords();
            else System.out.println("ERROR : Invalid Command!");
            System.out.println();
        }
    }
}
