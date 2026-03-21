import java.util.*;

class Solution{
    public int longestSubarray(int[] nums, int k){
        int n = nums.length;
        int left = 0, right = 0;
        int sum = nums[0];
        int maxlen = 0;
        while(right<n){
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
        }
        if(sum==k){
            maxlen = Math.max(maxlen, right-left+1);
        }
        right++;
        if(right<n){
            sum+=nums[right];
        }
        return maxlen;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        Solution sol = new Solution();
        int result = sol.longestSubarray(nums, k);

        System.out.println("Longest subarray length: " + result);
    }
}
