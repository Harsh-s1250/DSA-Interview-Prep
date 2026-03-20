# Max Consecutive Ones

## Problem Statement
Given a binary array `nums`, return the **maximum number of consecutive 1s** in the array.

---

## Example

Input:
nums = [1, 1, 0, 1, 1, 1]

Output:
3

---

# Approach: Counting Streak (Optimal)

## Intuition
- Traverse the array once
- Count consecutive `1`s
- Reset count when `0` appears
- Track the maximum count

This works because we only care about **continuous segments of 1s**

---

## Algorithm
1. Initialize `count = 0` and `max = 0`
2. Traverse the array:
   - If element is `1` → increment count
   - If element is `0` → reset count to 0
3. Update maximum after each step
4. Return maximum count

---

## Code

```java
import java.util.*;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }

        return max;
    }
}
```

---

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

---

## Why This Works
- Tracks only consecutive elements
- No extra space used
- Single pass solution

---

## Common Mistakes

- Not resetting count on `0`
- Updating max at wrong place
- Overcomplicating with extra data structures

---

## Key Takeaways

- This is a **longest subarray / streak counting problem**
- Always reset when condition breaks
- Maintain max while traversing