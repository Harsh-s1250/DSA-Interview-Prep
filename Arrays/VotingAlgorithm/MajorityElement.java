import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        if (count > nums.length / 2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);
        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No majority element found");
        }
    }
}