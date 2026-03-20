import java.util.*;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
                if (cnt > maxi) {
                    maxi = cnt;
                }
            } else {
                cnt = 0;
            }
        }

        return maxi;
    }
}