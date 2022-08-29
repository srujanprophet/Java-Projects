// 1. Numbers Only

package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> nums = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            nums.add(number);
        }

        long max_num = Collections.max(nums);
        int max_count = 0;
        for (Long x : nums) {
            if (x == max_num) max_count++;
        }

        System.out.println("Total numbers: " + nums.size() + ".");
        System.out.printf("The greatest number: %d (%d time(s)).\n", max_num, max_count);
    }
}
