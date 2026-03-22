# Two Sum Problem

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to the target.

---

## Approach 1: Brute Force (Nested Loops)

### Intuition

Check every possible pair and return the first pair whose sum equals the target.

### Code

```java
import java.util.*;

public class TwoSumBruteForce {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] res = twoSum(nums, target);
        System.out.println("Indices: " + res[0] + ", " + res[1]);
    }
}
```

### Complexity

* Time: O(n²)
* Space: O(1)

### Problem

Too slow for large inputs.

---

## Approach 2: Sorting + Two Pointers

### Intuition

Sort the array but preserve original indices using a 2D array. Then apply two pointers.

### Code

```java
import java.util.*;

public class TwoSumSorting {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] numsWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }

        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                return new int[]{
                    numsWithIndex[left][1],
                    numsWithIndex[right][1]
                };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] res = twoSum(nums, target);
        System.out.println("Indices: " + res[0] + ", " + res[1]);
    }
}
```

### Complexity

* Time: O(n log n)
* Space: O(n)

### Problem

Extra space + sorting overhead.

---

## Approach 3: Optimal (HashMap)

### Intuition

Store visited elements in a HashMap and check for complement in one pass.

### Code

```java
import java.util.*;

public class TwoSumHashMap {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] res = twoSum(nums, target);
        System.out.println("Indices: " + res[0] + ", " + res[1]);
    }
}
```

### Complexity

* Time: O(n)
* Space: O(n)

### Advantage

Fastest and expected solution in interviews.

---

## Final Comparison

| Approach              | Time Complexity | Space | Verdict |
| --------------------- | --------------- | ----- | ------- |
| Brute Force           | O(n²)           | O(1)  | Worst   |
| Sorting + Two Pointer | O(n log n)      | O(n)  | Better  |
| HashMap               | O(n)            | O(n)  | Best    |

---

## Category

* Array
* Hashing

---

## Key Takeaways

* Don’t jump to brute force in interviews
* Sorting approach is acceptable but not optimal
* HashMap is the standard expected solution
* Always preserve indices when modifying array order
