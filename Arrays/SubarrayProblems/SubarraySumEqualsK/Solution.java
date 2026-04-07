import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;

            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Solution obj = new Solution();
        int result = obj.subarraySum(nums, k);
        System.out.println(result);
    }
}