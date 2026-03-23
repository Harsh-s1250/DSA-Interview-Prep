# Maximum Subarray Sum (Kadane’s Algorithm)

## Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one element) which has the largest sum and return its sum.

---

## Approach

### Brute Force Approach
- Generate all possible subarrays.
- Calculate the sum of each subarray.
- Keep track of the maximum sum.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

---

### Optimized Approach (Kadane’s Algorithm)

This approach efficiently finds the maximum subarray sum in a single pass.

#### Key Idea
- Maintain a running sum of elements.
- If the running sum becomes negative, reset it to 0.
- Track the maximum sum encountered during traversal.

#### Steps
1. Initialize:
   - `sum = 0`
   - `maxi = Long.MIN_VALUE`
2. Traverse the array:
   - Add current element to `sum`
   - Update `maxi = max(maxi, sum)`
   - If `sum < 0`, reset `sum = 0`
3. Return `maxi`

---

## Code Implementation (Java)

```java
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
```

---

## Complexity Analysis

- **Time Complexity:** O(n)  
  Single traversal of the array.

- **Space Complexity:** O(1)  
  No extra space used.

---

## Edge Cases

1. All elements are negative  
   - The algorithm correctly returns the maximum (least negative) element.

2. Single element array  
   - That element itself is the answer.

3. Large input values  
   - `long` is used to avoid overflow during summation.