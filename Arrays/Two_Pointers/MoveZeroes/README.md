# Move Zeroes

## Problem Link
https://leetcode.com/problems/move-zeroes

## Problem

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

You must do this **in-place** without making a copy of the array.

### Example

Input

```
nums = [0,1,0,3,12]
```

Output

```
[1,3,12,0,0]
```

---

## Intuition

The idea is to keep track of the position where the next non-zero element should be placed.

* Use a pointer `k` that represents the index where the next non-zero element should go.
* Traverse the array using another pointer `i`.
* Whenever a non-zero element is found, swap it with the element at index `k`.
* Increment `k` after placing the non-zero element.

This way:

* All non-zero elements move to the front.
* All zeros automatically shift to the end.

---

## Approach (Two Pointers)

1. Initialize `k = 0`.
2. Traverse the array using index `i`.
3. If `nums[i]` is not `0`:

   * Swap `nums[i]` and `nums[k]`
   * Increment `k`
4. Continue until the end of the array.

This maintains the order of non-zero elements while moving zeros to the end.

---

## Java Implementation

```java
import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                k++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Original Array: " + Arrays.toString(nums));

        moveZeroes(nums);

        System.out.println("After Moving Zeroes: " + Arrays.toString(nums));
    }
}
```

---

## Complexity Analysis

**Time Complexity:**
`O(n)` – The array is traversed once.

**Space Complexity:**
`O(1)` – No extra space is used since the operation is done in-place.

---

## Category

* Array
* Two Pointers
* In-place Array Manipulation
