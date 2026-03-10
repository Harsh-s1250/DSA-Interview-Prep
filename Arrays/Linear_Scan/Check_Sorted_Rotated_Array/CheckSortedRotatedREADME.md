# Check if Array is Sorted and Rotated

# Problem Link
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated

## Problem

Given an array `nums`, check whether the array was originally sorted in non-decreasing order and then possibly rotated.

A rotation means taking some elements from the beginning of the array and moving them to the end.

Example:

Sorted array
[1,2,3,4,5]

Rotated array
[3,4,5,1,2]

Return **true** if the array can be obtained by rotating a sorted array, otherwise return **false**.

---

## Intuition

In a sorted array, every element should be **greater than or equal to the previous element**.

Example:

1 2 3 4 5

But when the array is rotated, there will be **exactly one place where the order breaks**.

Example:

3 4 5 1 2

Here the order breaks at:

5 > 1

So the idea is simple:

1. Traverse the array once.
2. Count how many times nums[i-1] > nums[i].
3. Also check the last and first element (nums[n-1] > nums[0]).
4. If the count of such breaks is **more than 1**, the array is not a rotated sorted array.

---

## Algorithm

1. Initialize a variable count = 0
2. Traverse the array from index 1 to n-1
3. If nums[i-1] > nums[i], increment count
4. Check if nums[n-1] > nums[0], increment count
5. If count <= 1 return true, otherwise return false

---

## Code (Java)

```java
public boolean check(int[] nums) {
    int n = nums.length;
    int count = 0;

    for(int i = 1; i < n; i++){
        if(nums[i-1] > nums[i]){
            count++;
        }
    }

    if(nums[n-1] > nums[0]){
        count++;
    }

    return count <= 1;
}
```

---

## Complexity

Time Complexity: **O(n)**
Space Complexity: **O(1)**

---

## Category

Arrays → Linear Scan / Traversal