// 5. Notification Service

package tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public String getName() {return name; }
    public String getEmail() { return email; }

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

    public HashMap<String, Integer> getPoints() {
        return points;
    }
}

public class Main {

    static Long cur_ID = 1000L;
    static HashSet<String> emails = new HashSet<>();
    static SortedMap<Long, Student> students = new TreeMap<>();
    static HashMap<String, Integer> submissions = new HashMap<>();
    static HashMap<String, Integer> enrolled = new HashMap<>();
    static HashMap<String, Integer> total_points = new HashMap<>();
    static HashMap<String, Integer> max_points = new HashMap<>();
    static HashMap<Long, ArrayList<String>> notified = new HashMap<>();

    static void init_stats() {
        submissions.put("Java", 0); submissions.put("DSA", 0);
        submissions.put("Databases", 0); submissions.put("Spring", 0);
        enrolled.put("Java", 0); enrolled.put("DSA", 0);
        enrolled.put("Databases", 0); enrolled.put("Spring", 0);
        total_points.put("Java", 0); total_points.put("DSA", 0);
        total_points.put("Databases", 0); total_points.put("Spring", 0);
        max_points.put("Java", 600); max_points.put("DSA", 400);
        max_points.put("Databases", 480); max_points.put("Spring", 550);
    }

    static int create_student(String first_name, String last_name, String email) {
        String name = first_name + " " + last_name;
        if (emails.contains(email)) {
            System.out.print("This email is already taken.\n ");
            return 0;
        }
        Student s = new Student(cur_ID++, email, name);
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

    static void update_submissions(ArrayList<Integer> points) {
        if (points.get(0) > 0) submissions.put("Java", submissions.get("Java") + 1);
        if (points.get(1) > 0) submissions.put("DSA", submissions.get("DSA") + 1);
        if (points.get(2) > 0) submissions.put("Databases", submissions.get("Databases") + 1);
        if (points.get(3) > 0) submissions.put("Spring", submissions.get("Spring") + 1);
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
        update_submissions(points);
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

    static void printStatistics() {
        for (Student s: students.values()) {
            HashMap<String, Integer> points = s.getPoints();
            for (String course : points.keySet()) {
                if (points.get(course) > 0) {
                    enrolled.put(course, enrolled.get(course) + 1);
                }
                total_points.put(course, total_points.get(course) + points.get(course));
            }
        }
        StringBuilder mostPopular = new StringBuilder("n/a");
        StringBuilder leastPopular = new StringBuilder("n/a");
        StringBuilder highestActivity = new StringBuilder("n/a");
        StringBuilder lowestActivity = new StringBuilder("n/a");
        String easiestCourse = "n/a";
        String hardestCourse = "n/a";
        int most_enrolled = Collections.max(enrolled.values());
        int least_enrolled = Collections.min(enrolled.values());
        int most_submissions = Collections.max(submissions.values());
        int least_submissions = Collections.min(submissions.values());
        double highest_average = -1d;
        double lowest_average = Integer.MAX_VALUE;
        if (most_enrolled != 0) {
            mostPopular = new StringBuilder();
            leastPopular = new StringBuilder();
            for (String course: enrolled.keySet()) {
                if (enrolled.get(course) == most_enrolled) mostPopular.append(course).append(", ");
                if (enrolled.get(course) == least_enrolled) leastPopular.append(course).append(", ");
            }
            mostPopular.deleteCharAt(mostPopular.length() - 2);
            leastPopular.deleteCharAt(leastPopular.length() - 2);
            if (least_enrolled == most_enrolled) leastPopular = new StringBuilder("n/a");
            if (most_submissions != 0) {
                highestActivity = new StringBuilder();
                lowestActivity = new StringBuilder();
                for (String course: submissions.keySet()) {
                    if (submissions.get(course) == most_submissions) highestActivity.append(course).append(", ");
                    if (submissions.get(course) == least_submissions) lowestActivity.append(course).append(", ");
                }
                highestActivity.deleteCharAt(highestActivity.length() - 2);
                lowestActivity.deleteCharAt(lowestActivity.length() - 2);
                if (most_submissions == least_submissions) lowestActivity = new StringBuilder("n/a");
            }
            for (String course: total_points.keySet()) {
                if (enrolled.get(course) != 0) {
                    double avg_score = Double.valueOf(total_points.get(course)) / enrolled.get(course);
                    if (avg_score >= highest_average) {
                        highest_average = avg_score;
                        easiestCourse = course;
                    }
                    if (avg_score < lowest_average) {
                        lowest_average = avg_score;
                        hardestCourse = course;
                    }
                }
            }
        }
        System.out.print("Most popular: " + mostPopular + "\n ");
        System.out.print("Least popular: " + leastPopular + "\n ");
        System.out.print("Highest activity: " + highestActivity + "\n ");
        System.out.print("Lowest activity: " + lowestActivity + "\n ");
        System.out.print("Easiest course: " + easiestCourse + "\n ");
        System.out.print("Hardest course: " + hardestCourse + "\n ");
    }

    static String toCamelCase(String course) {
        if (course.equalsIgnoreCase("java")) return "Java";
        if (course.equalsIgnoreCase("dsa")) return "DSA";
        if (course.equalsIgnoreCase("databases")) return "Databases";
        if (course.equalsIgnoreCase("spring")) return "Spring";
        return "Unknown course.";
    }

    static HashMap<Long, Double> sortHashMap(HashMap<Long, Double> map) {
        List<Map.Entry<Long, Double>> list = new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        HashMap<Long, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<Long, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    static void printCourseDetails(String course) {
        String course_name = toCamelCase(course);
        if (course_name.equalsIgnoreCase("unknown course.")) {
            System.out.print("Unknown course.\n");
            return;
        }
        System.out.print(course_name + "\n");
        System.out.print("id   points   completed\n");
        int maxPoints = max_points.get(course_name);
        HashMap<Long, Double> course_scores = new HashMap<>();
        for (var s: students.entrySet()) {
            Double course_points = Double.valueOf(s.getValue().getPoints().get(course_name));
            if (course_points > 0) {
                double percentage = (course_points * 100) / maxPoints;
                BigDecimal bd = new BigDecimal(percentage);
                bd = bd.setScale(1, RoundingMode.HALF_UP);
                double d = bd.doubleValue();
                course_scores.put(s.getKey(), -d);
            }
        }
        HashMap<Long, Double> sortedStudents = sortHashMap(course_scores);
        for (var score: sortedStudents.entrySet()) {
            int student_points = students.get(score.getKey()).getPoints().get(course_name);
            int max_point_len = 7 - String.valueOf(student_points).length();
            System.out.printf("%d %d %s %.1f%%\n", score.getKey(), student_points,
                    " ".repeat(max_point_len), -score.getValue());
        }
    }

    static boolean alreadyNotified(Long s_id, String course) {
        if (notified.containsKey(s_id))
            return notified.get(s_id).contains(course);
        return false;
    }

    static void notify(Student s, String course) {
        System.out.printf("To: %s\nRe: Your Learning Progress\n", s.getEmail());
        System.out.printf("Hello, %s! You have accomplished our %s course!\n", s.getName(), course);
    }

    static boolean isAccomplished(Student s, String course) {
        return Objects.equals(s.getPoints().get(course), max_points.get(course));
    }

    static int notifyStudents() {
        HashSet<Long> students_notified = new HashSet<>();
        for (Student s: students.values()) {
            for (String course: max_points.keySet()) {
                if (!alreadyNotified(s.getID(), course) && isAccomplished(s, course)) {
                    notify(s, course);
                    if (notified.containsKey(s.getID())) {
                        ArrayList<String> temp = notified.get(s.getID());
                        temp.add(course);
                        notified.put(s.getID(), temp);
                    } else {
                        ArrayList<String> temp = new ArrayList<>(List.of(course));
                        notified.put(s.getID(), temp);
                    }
                    students_notified.add(s.getID());
                }
            }
        }
        return students_notified.size();
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init_stats();
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
                } else if (input.equalsIgnoreCase("statistics")) {
                    System.out.print("Type the name of a course to see details or 'back' to quit\n ");
                    printStatistics();
                    do {
                        String course_name = br.readLine();
                        if (course_name.equalsIgnoreCase("back")) {
                            System.out.print(" ");
                            break;
                        }
                        printCourseDetails(course_name);
                        System.out.print(" ");
                    } while (true);
                } else if (input.equalsIgnoreCase("notify")) {
                    int num_students = notifyStudents();
                    System.out.print("Total " + num_students + " students have been notified\n ");
                } else System.out.print("Error: unknown command!\n ");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
