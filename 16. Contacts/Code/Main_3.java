// 3. Upgrade Your Contacts

package contacts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
    String name;
    String phone;
    boolean person;
    LocalDateTime createTime;
    LocalDateTime lastEditTime;

    Record() {
        this.createTime = LocalDateTime.now();
        this.lastEditTime = LocalDateTime.now();
    }
    private boolean isValidPhone(String phone) {
        String p1 = "\\+?[\\da-zA-Z]+([-\\s]?[a-zA-Z\\d]{2,})*"; // No parentheses
        String p2 = "\\+?\\([\\dA-Za-z]+\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 1st group parentheses
        String p3 = "\\+?[\\dA-Za-z]+[-\\s]\\([\\dA-Za-z]{2,}\\)([-\\s]?[a-zA-Z\\d]{2,})*"; // 2nd group parentheses

        Matcher m1 = Pattern.compile(p1).matcher(phone);
        Matcher m2 = Pattern.compile(p2).matcher(phone);
        Matcher m3 = Pattern.compile(p3).matcher(phone);

        return (m1.matches() || m2.matches() || m3.matches());
    }

    public void setPhone(String phone) {
        if (isValidPhone(phone)) this.phone = phone;
        else {
            System.out.println("Wrong number format!");
            this.phone = "";
        }
    }

    public String getPhone() { return this.phone; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public boolean hasNumber() { return this.phone.length() != 0; }

    public boolean isPerson() { return this.person; }

    public void updateLastEdit() { this.lastEditTime = LocalDateTime.now(); }
}

class PersonRecord extends Record {
    String surname;
    String birthDate;
    String gender;

    PersonRecord() {
        this.person = true;
        this.birthDate = "";
        this.gender = "";
    }

    public void setSurname(String surname) { this.surname = surname; }

    public String getSurname() { return this.surname; }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty()) System.out.println("Bad birth date!");
        else this.birthDate = birthDate;
    }

    public String getBirthDate() { return this.birthDate; }

    public void setGender(String gender) {
        if (gender.equals("F") || gender.equals("M")) this.gender = gender;
        else System.out.println("Bad gender!");
    }

    public String getGender() { return this.gender; }

    public String toString() {
        return String.format("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\nNumber: %s\n" +
                "Time created: %s\nTime last edit: %s\n", this.name, this.surname,
                (this.birthDate.isEmpty() ? "[no data]":this.birthDate),
                (this.gender.isEmpty() ? "[no data]":this.gender), this.phone,
                this.createTime.truncatedTo(ChronoUnit.SECONDS),
                this.lastEditTime.truncatedTo(ChronoUnit.SECONDS));
    }
}

class OrganizationRecord extends Record {

    String address;

    OrganizationRecord() {
        this.person = false;
    }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return this.address; }

    public String toString() {
        return String.format("Organization name: %s\nAddress: %s\nNumber: %s\nTime created: %s" +
                "\nTime last edit: %s\n", this.name, this.address, this.phone,
                this.createTime.truncatedTo(ChronoUnit.MINUTES),
                this.lastEditTime.truncatedTo(ChronoUnit.MINUTES));
    }
}

class App {

    ArrayList<Record> records = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private void addPerson() {
        PersonRecord rec = new PersonRecord();
        System.out.print("Enter the name: ");
        rec.setName(sc.nextLine());
        System.out.print("Enter the surname: ");
        rec.setSurname(sc.nextLine());
        System.out.print("Enter the birth date: ");
        rec.setBirthDate(sc.nextLine());
        System.out.print("Enter the gender (M, F): ");
        rec.setGender(sc.nextLine());
        System.out.print("Enter the number: ");
        rec.setPhone(sc.nextLine());
        records.add(rec);
    }

    private void addOrganization() {
        OrganizationRecord rec = new OrganizationRecord();
        System.out.print("Enter the organization name: ");
        rec.setName(sc.nextLine());
        System.out.print("Enter the address: ");
        rec.setAddress(sc.nextLine());
        System.out.print("Enter the number: ");
        rec.setPhone(sc.nextLine());
        records.add(rec);
    }

    private void editPerson(Record rec) {
        PersonRecord updatePerson = (PersonRecord) rec;
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = sc.nextLine();
        if (field.equalsIgnoreCase("name")) {
            System.out.print("Enter name: ");
            updatePerson.setName(sc.nextLine());
        } else if (field.equalsIgnoreCase("surname")) {
            System.out.print("Enter surname: ");
            updatePerson.setSurname(sc.nextLine());
        } else if (field.equalsIgnoreCase("birth")) {
            System.out.print("Enter birth: ");
            updatePerson.setBirthDate(sc.nextLine());
        } else if (field.equalsIgnoreCase("gender")) {
            System.out.print("Enter gender: ");
            updatePerson.setGender(sc.nextLine());
        } else if (field.equalsIgnoreCase("number")) {
            System.out.print("Enter number: ");
            updatePerson.setPhone(sc.nextLine());
        } else System.out.println("ERROR : Invalid Field!");
    }

    private void editOrganization(Record rec) {
        OrganizationRecord updateOrg = (OrganizationRecord) rec;
        System.out.print("Select a field (address, number): ");
        String field = sc.nextLine();
        if (field.equalsIgnoreCase("address")) {
            System.out.print("Enter address: ");
            updateOrg.setAddress(sc.nextLine());
        } else if (field.equalsIgnoreCase("number")) {
            System.out.print("Enter number: ");
            updateOrg.setPhone(sc.nextLine());
        } else System.out.println("ERROR : Invalid Field!");
    }

    public void addRecord() {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        if (type.equalsIgnoreCase("person")) addPerson();
        else if (type.equalsIgnoreCase("organization")) addOrganization();
        else System.out.println("Invalid type\n");
        System.out.println("The record added.\n");
    }

    public void countRecords() {
        System.out.printf("The Phone Book has %d records.\n\n", records.size());
    }

    public void editRecord() {
        if (records.isEmpty()) System.out.println("No records to edit!");
        else {
            listRecords();
            System.out.print("Select a record: ");
            int idx = Integer.parseInt(sc.nextLine());
            Record updateRec = records.get(idx - 1);
            if (updateRec.isPerson()) editPerson(updateRec);
            else editOrganization(updateRec);
            updateRec.updateLastEdit();
            System.out.println("The record updated!\n");
        }
    }

    public void removeRecord() {
        if (records.isEmpty()) System.out.println("No records to remove!");
        else {
            this.listRecords();
            System.out.print("Select a record: ");
            int idx = Integer.parseInt(sc.nextLine());
            records.remove(idx - 1);
            System.out.println("The record removed!\n");
        }
    }

    public void listRecords() {
        String name;
        for (int i = 1; i <= records.size(); i++) {
            if (records.get(i-1).isPerson()) {
                PersonRecord person = (PersonRecord) records.get(i-1);
                name = person.getName() + " " + person.getSurname();
            } else {
                name = records.get(i-1).getName();
            }
            System.out.println(i + ". " + name);
        }
    }

    public void getRecordInfo() {
        listRecords();
        System.out.print("Enter index to show info: ");
        int idx = Integer.parseInt(sc.nextLine());
        if (records.get(idx - 1).isPerson()) {
            PersonRecord rec = (PersonRecord) records.get(idx - 1);
            System.out.println(rec);
        } else {
            OrganizationRecord rec = (OrganizationRecord) records.get(idx - 1);
            System.out.println(rec);
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String action = sc.next();
            if (action.equalsIgnoreCase("exit")) break;
            else if (action.equalsIgnoreCase("add")) app.addRecord();
            else if (action.equalsIgnoreCase("remove")) app.removeRecord();
            else if (action.equalsIgnoreCase("edit")) app.editRecord();
            else if (action.equalsIgnoreCase("count")) app.countRecords();
            else if (action.equalsIgnoreCase("info")) app.getRecordInfo();
            else System.out.println("ERROR : Invalid Command!");
        }
    }
}
