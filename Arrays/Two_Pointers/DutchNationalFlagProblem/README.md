# Sort Colors (Dutch National Flag Problem)

## Problem Statement

Given an array `nums` with `n` objects colored red (0), white (1), and blue (2), sort them in-place so that objects of the same color are adjacent, with the colors in the order 0, 1, 2.

You must solve this problem without using the library sort function.

---

## Approach 1: Counting Frequencies (Better)

### Intuition

Count how many 0s, 1s, and 2s are present, then overwrite the array based on these counts.

### Steps

1. Traverse the array and count occurrences of 0, 1, and 2.
2. Overwrite the array:

   * First fill all 0s
   * Then fill all 1s
   * Then fill all 2s

### Code

```java id="c1"
import java.util.*;

public class SortColorsCounting {

    public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int index = 0;

        for (int i = 0; i < count0; i++) nums[index++] = 0;
        for (int i = 0; i < count1; i++) nums[index++] = 1;
        for (int i = 0; i < count2; i++) nums[index++] = 2;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

### Complexity

* Time: O(n)
* Space: O(1)

### Drawback

Requires two passes over the array.

---

## Approach 2: Overwriting Array (Same Idea, Different Expression)

### Intuition

This is essentially the same as counting, but written in a more direct overwrite style without explicitly separating loops conceptually.

### Code

```java id="c2"
import java.util.*;

public class SortColorsOverwrite {

    public static void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }

        int index = 0;

        for (int color = 0; color < 3; color++) {
            while (count[color] > 0) {
                nums[index++] = color;
                count[color]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

### Complexity

* Time: O(n)
* Space: O(1)

### Note

This is still counting-based. The only difference is how the overwrite loop is structured.

---

## Approach 3: Dutch National Flag (Optimal)

### Intuition

Partition the array into three sections using three pointers:

* `low` for 0s
* `mid` for traversal
* `high` for 2s

### Key Idea

Maintain three regions:

* `[0 ... low-1]` → 0s
* `[low ... mid-1]` → 1s
* `[mid ... high]` → unknown
* `[high+1 ... n-1]` → 2s

### Code

```java id="c3"
import java.util.*;

public class SortColorsDNF {

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

### Complexity

* Time: O(n)
* Space: O(1)

### Advantage

* Single pass
* In-place
* No extra counting or second traversal

---

## Comparison

| Approach             | Time | Space | Passes | Remarks                   |
| -------------------- | ---- | ----- | ------ | ------------------------- |
| Counting Frequencies | O(n) | O(1)  | 2      | Simple, easy to implement |
| Overwriting Array    | O(n) | O(1)  | 2      | Same as counting variant  |
| Dutch National Flag  | O(n) | O(1)  | 1      | Most efficient            |

---

## Category

* Array
* Two Pointers (Dutch National Flag)
* Partitioning

---

## Key Takeaways

* Counting works but is not optimal in terms of passes
* Dutch National Flag solves it in one traversal
* Understanding pointer movement is more important than memorizing code
* This pattern appears in partitioning-based problems
