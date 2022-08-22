// 3. A Detailed Record

package tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    Long ID;
    String email;
    String name;
    HashMap<String, Integer> points = new HashMap<>();

    Student(Long ID, String email, String name) {
        this.ID = ID;
        this.email = email;
        this.name = name;
        this.points.put("Java", 0);
        this.points.put("DSA", 0);
        this.points.put("Databases", 0);
        this.points.put("Spring", 0);
    }

    public Long getID() { return ID; }
//    public String getEmail() { return email; }
//    public String getName() { return name; }
    public void updatePoints(ArrayList<Integer> new_points) {
        points.put("Java", points.get("Java") + new_points.get(0));
        points.put("DSA", points.get("DSA") + new_points.get(1));
        points.put("Databases", points.get("Databases") + new_points.get(2));
        points.put("Spring", points.get("Spring") + new_points.get(3));
    }

    public void printPoints() {
        System.out.printf("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d\n ",
                this.ID, this.points.get("Java"), this.points.get("DSA"),
                this.points.get("Databases"), this.points.get("Spring"));
    }
}

public class Main {

    static Long cur_ID = 1000L;
    static HashSet<String> emails = new HashSet<>();
    static SortedMap<Long, Student> students = new TreeMap<>();


    static int create_student(String first_name, String last_name, String email) {
        String name = first_name + " " + last_name;
        if (emails.contains(email)) {
            System.out.print("This email is already taken.\n ");
            return 0;
        }
        Student s = new Student(cur_ID++, name, email);
        emails.add(email);
        students.put(s.getID(), s);
        System.out.print("The student has been added.\n ");
        return 1;
    }

    static int add_student(String student_details) {
        String[] s_details = student_details.split(" ");
        String name_regex = "(^[^-&^'])(?=\\S*['-]*)([a-zA-Z'-]+)";
        String email_regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9]+\\.[a-zA-Za-z0-9.]+$";


        if (s_details.length < 3) {
            System.out.print("Incorrect credentials\n "); return 0;
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
            return create_student(first_name, last_name, email_id);
        } else if (!first_name.matches(name_regex) || first_name.endsWith("-")
                || first_name.endsWith("'") || first_name.contains("-'") || first_name.contains("'-")
                || first_name.contains("--") || first_name.contains("''")) {
            System.out.print("Incorrect first name\n "); return 0;
        } else if (!last_name.matches(name_regex) || last_name.endsWith("-")
                || last_name.endsWith("'") || last_name.contains("-'") || last_name.contains("'-")
                || last_name.contains("''") || last_name.contains("--")) {
            System.out.print("Incorrect last name\n "); return 0;
        } else if (!email_id.matches(email_regex)) {
            System.out.print("Incorrect email\n "); return 0;
        }
        return 0;
    }

    static void list_students() {
        if (students.size() == 0) System.out.print("No students found\n ");
        else {
            System.out.println("Students:");
            for (var student: students.entrySet()) {
                System.out.println(student.getValue().getID());
            }
        }
    }

    static int add_points(String input) {
        if (input.equalsIgnoreCase("back")) return -1;
        String[] inputs = input.split(" ");
        try {
            if (!students.containsKey(Long.parseLong(inputs[0]))) {
                System.out.printf("No student is found for id=%d\n ", Long.parseLong(inputs[0]));
                return 0;
            }
        } catch (NumberFormatException e) {
            System.out.printf("No student is found for id=%s\n ", inputs[0]);
            return 0;
        }
        ArrayList<Integer> points = new ArrayList<>();
        if (inputs.length != 5) {
            System.out.print("Incorrect points format.\n ");
            return 0;
        }
        try {
            for (int i = 1; i < 5; i++) {
                int point = Integer.parseInt(inputs[i]);
                if (point < 0) {
                    throw new NumberFormatException("Error!");
                }
                points.add(point);
            }
        } catch (NumberFormatException e) {
            System.out.print("Incorrect points format\n ");
            return 0;
        }
        Student s = students.get(Long.parseLong(inputs[0]));
        s.updatePoints(points);
        students.put(s.getID(), s);
        System.out.print("Points updated.\n ");
        return 1;
    }

    static int find(String input) {
        if (input.equalsIgnoreCase("back")) return -1;
        Long id = Long.parseLong(input);
        if (students.containsKey(id)) {
            students.get(id).printPoints();
        } else {
            System.out.printf("No student is found for id=%s\n", input);
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Learning Progress Tracker\n ");
        try {
            while (true) {
                String input = br.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Bye!");
                    break;
                } else if (input.trim().length() == 0) {
                    System.out.print("No input.\n ");
                } else if (input.equalsIgnoreCase("back")) {
                    System.out.print("Enter 'exit' to exit the program\n ");
                } else if (input.equalsIgnoreCase("add students")) {
                    int students_added = 0;
                    System.out.print("Enter student credentials or 'back' to return:\n ");
                    do {
                        String student_details = br.readLine();
                        if (student_details.equalsIgnoreCase("back")) {
                            System.out.printf("Total %d students have been added.\n ", students_added);
                            break;
                        }
                        students_added += add_student(student_details);
                    } while (true);
                } else if (input.equalsIgnoreCase("list")) {
                    list_students();
                } else if (input.equalsIgnoreCase("add points")) {
                    System.out.print("Enter an id and points or 'back' to return:\n ");
                    do {
                        String add_points_input = br.readLine();
                        int status = add_points(add_points_input);
                        if (status == -1) {
                            System.out.print(" ");
                            break;
                        }
                    } while (true);
                } else if (input.equalsIgnoreCase("find")) {
                    System.out.print("Enter an id or 'back' to return:\n ");
                    do {
                        String find_input = br.readLine();
                        int status = find(find_input);
                        if (status == -1) {
                            System.out.print(" ");
                            break;
                        }
                    } while (true);
                } else System.out.print("Error: unknown command!\n ");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
