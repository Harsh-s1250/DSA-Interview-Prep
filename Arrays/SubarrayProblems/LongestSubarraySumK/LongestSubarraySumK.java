import java.util.*;

public class LongestSubarraySumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;

        System.out.println(longestSubarray(arr, k));
    }

    public static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}