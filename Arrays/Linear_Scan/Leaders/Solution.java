import java.util.*;

class Solution {
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (nums.length == 0) {
            return ans;
        }

        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        
        Solution finder = new Solution();
        
        ArrayList<Integer> ans = finder.leaders(nums);
        
        System.out.print("Leaders in the array are: ");
        for (int leader : ans) {
            System.out.print(leader + " ");
        }
        System.out.println();
    }
}