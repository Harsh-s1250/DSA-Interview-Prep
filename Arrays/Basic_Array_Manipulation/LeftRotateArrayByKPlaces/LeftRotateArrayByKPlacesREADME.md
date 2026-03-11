# Rotate Array

## Problem

Given an integer array `nums`, rotate the array to the **right by `k` steps**.

A rotation means shifting the elements of the array to the right, and the elements that fall off the end move to the beginning.

Example:

Input  
`nums = [1,2,3,4,5,6,7]`, `k = 3`

Output  
`[5,6,7,1,2,3,4]`

---

## Intuition

When we rotate an array to the **right by `k` positions**, the last `k` elements move to the beginning of the array.

Example:

Original array  

`1 2 3 4 5 6 7`

Right rotation by `3`

`5 6 7 1 2 3 4`

One efficient way to achieve this is by using the **Reversal Algorithm**.

Steps:

1. Reverse the entire array
2. Reverse the first `k` elements
3. Reverse the remaining `n-k` elements

This rearranges the elements into the correct rotated order.

---

## Algorithm (Reversal Approach)

1. Find the length of the array `n`
2. Compute `k = k % n` to handle cases where `k > n`
3. Reverse the entire array
4. Reverse the first `k` elements
5. Reverse the remaining elements from `k` to `n-1`

---

## Code (Java)

```java
class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
```

---

## Alternative Approach (Using Extra Array)

Another approach is to use an **extra array** to store the rotated elements.

Idea:

- The new position of each element after rotation can be calculated using:

`(i + k) % n`

This ensures elements wrap around to the beginning of the array.

---

## Algorithm (Extra Array Approach)

1. Create a new array `temp` of size `n`
2. Traverse the original array
3. Place each element at index `(i + k) % n` in the new array
4. Copy the elements from the new array back to the original array

---

## Code (Java)

```java
class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for(int i = 0; i < n; i++){
            temp[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }
}
```

---

## Complexity

### Reversal Approach

Time Complexity: **O(n)**  
Space Complexity: **O(1)**

### Extra Array Approach

Time Complexity: **O(n)**  
Space Complexity: **O(n)**

---

## Category

Arrays → Array Rotation / Reversal Algorithm