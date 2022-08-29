// 2. Verify New Users

package tracker;

import java.util.Scanner;

public class Main {

    static int add_student(String student_details) {
        String[] s_details = student_details.split(" ");
        String name_regex = "(^[^-&^'])(?=\\S*['-]*)([a-zA-Z'-]+)";
        String email_regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9]+\\.[a-zA-Za-z0-9.]+$";

        if (s_details.length < 3) {
            System.out.println("Incorrect credentials"); return 0;
        }
        String first_name = s_details[0];
        StringBuilder last = new StringBuilder();
        for (int i = 1; i < s_details.length - 1; i++) last.append(s_details[i]);

        String last_name = last.toString();
        String email_id = s_details[s_details.length-1];
        if (first_name.matches(name_regex) && !first_name.endsWith("-") && !first_name.endsWith("'")
                && !first_name.contains("-'") && !first_name.contains("'-") && !first_name.contains("--")
                && !first_name.contains("''") && !last_name.contains("--") && !last_name.contains("''")
                && !last_name.contains("'-") && !last_name.contains("-'") && last_name.matches(name_regex)
                && !last_name.endsWith("-") && !last_name.endsWith("'") && email_id.matches(email_regex)) {
            System.out.println("The student has been added.");
            return 1;
        } else if (!first_name.matches(name_regex) || first_name.endsWith("-")
                || first_name.endsWith("'") || first_name.contains("-'") || first_name.contains("'-")
                || first_name.contains("--") || first_name.contains("''")) {
            System.out.println("Incorrect first name"); return 0;
        } else if (!last_name.matches(name_regex) || last_name.endsWith("-")
                || last_name.endsWith("'") || last_name.contains("-'") || last_name.contains("'-")
                || last_name.contains("''") || last_name.contains("--")) {
            System.out.println("Incorrect last name"); return 0;
        } else if (!email_id.matches(email_regex)) {
            System.out.println("Incorrect email"); return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            } else if (input.equalsIgnoreCase("back")) {
                System.out.println("Enter 'exit' to exit the program");
            } else if (input.equalsIgnoreCase("add students")) {
                int students_added = 0;
                System.out.println("Enter student credentials or 'back' to return:");
                do {
                    String student_details = sc.nextLine();
                    if (student_details.equalsIgnoreCase("back")) {
                        System.out.printf("Total %d students have been added.\n", students_added);
                        break;
                    }
                    students_added += add_student(student_details);
                } while (true);
            } else if (input.trim().length() == 0) System.out.println("No input.");
            else System.out.println("Error: unknown command!");
        }
    }
}
