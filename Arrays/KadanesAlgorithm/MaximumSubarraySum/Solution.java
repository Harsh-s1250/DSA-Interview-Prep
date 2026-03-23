import java.util.*;

public class Solution {

    public int maxSubArray(int[] nums) {
        long maxi = Long.MIN_VALUE; 
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            if (sum > maxi) {
                maxi = sum; 
            }
            if (sum < 0) {
                sum = 0; 
            }
        }
        return (int) maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int result = obj.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
        sc.close();
    }
}