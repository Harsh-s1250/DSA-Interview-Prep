# Left Rotate Array by One

## Problem

Given an array `nums`, perform a **left rotation by one position**.

A left rotation means moving the **first element of the array to the end**, while shifting all other elements one position to the left.

Example:

Input  
`[1,2,3,4,5]`

Output  
`[2,3,4,5,1]`

---

## Intuition

In a left rotation by one:

- The **first element moves to the last position**
- Every other element shifts **one position to the left**

Example:

Original array  

`1 2 3 4 5`

After shifting left  

`2 3 4 5 _`

Then place the first element at the end  

`2 3 4 5 1`

---

## Algorithm (In-place Approach)

1. Store the first element of the array
2. Traverse the array from index `1` to `n-1`
3. Shift every element one position to the left
4. Place the stored element at the last index
5. Return or print the modified array

---

## Code (Java)

```java
public static void leftRotateByOne(int[] nums){

    int first = nums[0];

    for(int i = 1; i < nums.length; i++){
        nums[i - 1] = nums[i];
    }

    nums[nums.length - 1] = first;
}
```

---

## Alternative Approach (Using Dummy Array)

Another way to solve this problem is by using an **extra array (dummy array)**.

Steps:

1. Create a dummy array of the same length as the original array
2. Shift all elements toward the left while copying them to the dummy array
3. Place the first element of the original array into the last index of the dummy array
4. Print or return the dummy array

---

## Algorithm (Dummy Array)

1. Create a new array `dummy` of size `n`
2. Copy elements from index `1` to `n-1` into the dummy array starting from index `0`
3. Place `nums[0]` at `dummy[n-1]`
4. Return or print the dummy array

---

## Code (Java)

```java
public static int[] leftRotateByOne(int[] nums){

    int n = nums.length;
    int[] dummy = new int[n];

    for(int i = 1; i < n; i++){
        dummy[i - 1] = nums[i];
    }

    dummy[n - 1] = nums[0];

    return dummy;
}
```

---

## Complexity

### In-place Approach

Time Complexity: **O(n)**  
Space Complexity: **O(1)**

### Dummy Array Approach

Time Complexity: **O(n)**  
Space Complexity: **O(n)**

---

## Category

Arrays → Traversal / Array Rotation