// 2. Expand the Search

package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> data = new ArrayList<>();
        System.out.println("Enter all people:");
        for (int i = 0; i < n; i++) {
            data.add(sc.nextLine());
        }
        System.out.println("\nEnter the number of search queries:");
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            System.out.println("\nEnter data to search people:");
            String search = sc.nextLine().toUpperCase();
            List<String> found = data.stream().filter(s -> s.toUpperCase().contains(search)).collect(Collectors.toList());
            if (found.isEmpty()) System.out.println("No matching people found.");
            else {
                System.out.println("\nFound people:");
                found.forEach(System.out::println);
            }
        }
    }
}
