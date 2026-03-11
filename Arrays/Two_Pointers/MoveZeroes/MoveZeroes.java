import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Original Array: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After Moving Zeroes: " + Arrays.toString(nums));
    }
}
