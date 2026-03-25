# Next Permutation

## Problem
Given an array of integers `nums`, rearrange it into the next lexicographically greater permutation.  
If such arrangement is not possible, rearrange it to the lowest possible order (sorted in ascending order).

---

## Brute Force Approach

### Idea
1. Generate all possible permutations of the array.
2. Sort all permutations in lexicographical order.
3. Find the current permutation using linear search.
4. Return the next permutation in the sorted list.
5. If it is the last permutation, return the first one.

### Steps
- Use recursion/backtracking to generate all permutations.
- Store them in a list.
- Sort the list.
- Traverse to find the given permutation.
- Return the next one.

### Time Complexity
- Generating permutations: **O(n!)**
- Sorting permutations: **O(n! * n)**
- Searching: **O(n!)**

👉 Overall: **O(n! * n)**

### Space Complexity
- **O(n! * n)** (to store all permutations)

### Why this is bad
- Completely impractical for even moderate `n` (n ≥ 10 becomes useless).
- Wastes time generating unnecessary permutations.
- Not acceptable in interviews.

---

## Optimized Approach (Greedy + Array Manipulation)

### Core Idea
Find the **next lexicographically greater permutation** by making the smallest possible change.

---

### Steps

1. **Find the Breakpoint**
   - Traverse from right to left.
   - Find first index `i` such that:
     ```
     nums[i] < nums[i + 1]
     ```
   - This is the point where order breaks.

2. **If No Breakpoint**
   - The array is in descending order.
   - Reverse the entire array.
   - This gives the smallest permutation.

3. **Find Next Greater Element**
   - Traverse from right again.
   - Find first element greater than `nums[i]`.
   - Swap it with `nums[i]`.

4. **Reverse the Suffix**
   - Reverse elements from `i + 1` to end.
   - This ensures the next smallest permutation.

---

### Example

Input: [1, 2, 3]
Output: [1, 3, 2]

Input: [3, 2, 1]
Output: [1, 2, 3]

---

### Time Complexity
- **O(n)**

### Space Complexity
- **O(1)** (in-place)

---

## Why This Works
- Right side is always in descending order before breakpoint.
- Swapping ensures just larger permutation.
- Reversing ensures minimal increase.

---

## Key Observations
- Always operate from the right side.
- Only one swap is needed.
- Reversal ensures correctness, not sorting.

---

## Category
- Array
- Greedy
- Permutation / Lexicographical Ordering

---

## Final Verdict

| Approach       | Time Complexity | Practical? |
|----------------|-----------------|------------|
| Brute Force    | O(n! * n)       |    No      |
| Optimized      | O(n)            |    Yes     |

---