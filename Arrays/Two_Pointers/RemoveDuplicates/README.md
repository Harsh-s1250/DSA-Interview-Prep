# Remove Duplicates from Sorted Array

# Problem Link
https://leetcode.com/problems/remove-duplicates-from-sorted-array

## Problem

Given a **sorted array `nums`**, remove the duplicates **in-place** such that each unique element appears only once.

Return the **number of unique elements `k`**.

The first `k` elements of the array should contain the unique elements in the same order.

Example:

Input  
[1,1,2,2,3]

Output  
k = 3

Modified array  
[1,2,3,_,_]

Only the first `k` elements are considered valid.

---

## Intuition

Since the array is **already sorted**, duplicate elements always appear **next to each other**.

Example:

1 1 2 2 3

Instead of removing elements, we overwrite duplicates by shifting unique elements forward.

We use **two pointers**:

- `i` → used to traverse the array
- `j` → position where the next unique element should be placed

Whenever we find a new element different from the previous one, we place it at index `j`.

---

## Algorithm (Two Pointer Approach)

1. Initialize `j = 1`
2. Traverse the array from index `1` to `n-1`
3. If `nums[i] != nums[i-1]`, copy `nums[i]` to index `j`
4. Increment `j`
5. Continue until the end of the array
6. Return `j`

---

## Code (Java)

```java
public int removeDuplicates(int[] nums) {
    int j = 1;

    for(int i = 1; i < nums.length; i++){
        if(nums[i] != nums[i-1]){
            nums[j] = nums[i];
            j++;
        }
    }

    return j;
}
```

---

## Alternative Approach (HashSet)

Another way to remove duplicates is by using a **HashSet**.  
A HashSet automatically stores only **unique elements**.

However, this approach requires **extra space**, so it is not the optimal solution.

---

## Algorithm (HashSet Approach)

1. Create a `HashSet`
2. Add all elements of the array to the set
3. Copy elements from the set back to the array
4. Return the size of the set

---

## Code (Java)

```java
import java.util.HashSet;

public int removeDuplicates(int[] nums) {

    HashSet<Integer> set = new HashSet<>();

    for(int num : nums){
        set.add(num);
    }

    int i = 0;

    for(int num : set){
        nums[i] = num;
        i++;
    }

    return set.size();
}
```

---

## Complexity

Two Pointer Approach  

Time Complexity: **O(n)**  
Space Complexity: **O(1)**

HashSet Approach  

Time Complexity: **O(n)**  
Space Complexity: **O(n)**

---

## Category

Arrays → Two Pointers / In-place Array Modification