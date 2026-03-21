# Longest Subarray with Sum K (Positive + Negative Numbers)

## Problem Statement
Given an array of integers `nums` (can include negative numbers) and an integer `k`, find the length of the **longest subarray** whose sum equals `k`.

---

## Example

Input:
nums = [1, -1, 5, -2, 3]  
k = 3  

Output:
4  

---

## Approach: Prefix Sum + HashMap

### Intuition
If:
currentSum - previousSum = k  
Then:
previousSum = currentSum - k  

Use a HashMap to store prefix sums and their indices.

---

### Algorithm
1. Initialize `sum = 0`, `maxLen = 0`
2. Use a HashMap to store prefix sum → index
3. Traverse array:
   - Add element to sum
   - If sum == k → update maxLen
   - If (sum - k) exists → update maxLen
4. Store first occurrence of each sum

---

### Code

```java
import java.util.*;

public class LongestSubarrayGeneral {

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(longestSubarray(nums, k));
    }

    public static int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

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
```

---

## Complexity

- Time Complexity: O(n)  
- Space Complexity: O(n)  

---

## Why This Works

- Handles negative numbers correctly  
- Does not rely on increasing/decreasing sum behavior  

---

## Key Takeaways

- Use prefix sum when negatives are involved  
- Sliding window fails in this case  
- Always store first occurrence of prefix sum  