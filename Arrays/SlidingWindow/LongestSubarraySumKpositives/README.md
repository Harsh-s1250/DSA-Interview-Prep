# Longest Subarray with Sum K (All Positive Numbers)

## Problem Statement
Given an array of **positive integers** `nums` and an integer `k`, find the length of the **longest subarray** whose sum equals `k`.

---

## Example

Input:
nums = [10, 5, 2, 7, 1, 9]  
k = 15  

Output:
4  

---

## Approach: Sliding Window

### Intuition
- Since all elements are positive:
  - Expanding window increases sum
  - Shrinking window decreases sum
- This allows efficient two-pointer technique

---

### Algorithm
1. Initialize `left = 0`, `right = 0`
2. Maintain a running sum
3. Expand window by moving `right`
4. If sum > k → shrink window from `left`
5. If sum == k → update max length

---

### Code

```java
import java.util.*;

public class LongestSubarrayPositive {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(longestSubarray(nums, k));
    }

    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int left = 0, right = 0;
        int sum = nums[0];
        int maxLen = 0;

        while (right < n) {

            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }
}
```

---

## Complexity

- Time Complexity: O(n)  
- Space Complexity: O(1)  

---

## Limitation

- Works only when all elements are positive  
- Fails if negative numbers are present  

---

## Key Takeaways

- Sliding window works only for monotonic sums  
- Always check constraints before applying this approach  