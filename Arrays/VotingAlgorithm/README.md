# Majority Element Problem

## Problem Statement

Given an integer array `nums`, return the element that appears more than `n/2` times. You may assume that the majority element always exists in the array.

---

## Approach 1: Brute Force (Nested Loops)

### Intuition

Check the frequency of each element by comparing it with every other element.

### Steps

1. Pick each element.
2. Count how many times it appears.
3. If count > n/2, return it.

### Code

```java
import java.util.*;

public class MajorityElementBruteForce {

    public static int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
```

### Complexity

* Time: O(n²)
* Space: O(1)

### Drawback

Very inefficient for large arrays.

---

## Approach 2: HashMap

### Intuition

Store frequency of each element using a HashMap and return the one whose count exceeds n/2.

### Steps

1. Traverse array.
2. Store count in map.
3. Check if any count > n/2.

### Code

```java
import java.util.*;

public class MajorityElementHashMap {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
```

### Complexity

* Time: O(n)
* Space: O(n)

### Drawback

Uses extra space.

---

## Approach 3: Boyer–Moore Voting Algorithm (Optimal)

### Intuition

Cancel out different elements. The majority element will remain because it appears more than all others combined.

### Steps

1. Initialize `count = 0` and `candidate = 0`.
2. Traverse array:

   * If count == 0 → set candidate
   * If element == candidate → increment count
   * Else → decrement count
3. Return candidate.

### Code

```java
import java.util.*;

public class MajorityElementVoting {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
                count = 1;
            } else if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
```

### Complexity

* Time: O(n)
* Space: O(1)

### Advantage

* Most optimal solution
* No extra space
* Single pass

---

## Comparison

| Approach    | Time Complexity | Space Complexity | Remarks          |
| ----------- | --------------- | ---------------- | ---------------- |
| Brute Force | O(n²)           | O(1)             | Slow             |
| HashMap     | O(n)            | O(n)             | Uses extra space |
| Boyer–Moore | O(n)            | O(1)             | Best solution    |

---

## Category

* Array
* Hashing
* Voting Algorithm (Boyer–Moore)

---

## Key Takeaways

* Brute force is only for understanding
* HashMap improves time but uses space
* Boyer–Moore is the most efficient approach
* Always verify assumptions (majority element existence)
