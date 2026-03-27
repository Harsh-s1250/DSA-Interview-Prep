# Longest Consecutive Sequence

## Problem
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

---

## 1. Brute Force Approach

### Idea
As you iterate through each number in the array, begin by checking if consecutive numbers like (x+1, x+2, x+3), and so on, exist in the array.

- For every element, perform a **linear search** to check if the next consecutive number exists.
- Keep counting the length of the sequence using a counter.
- Update the maximum length whenever a longer sequence is found.

### Steps
1. Pick each element `x` from the array.
2. Initialize `count = 1`.
3. Check if `x+1` exists using linear search.
4. If yes, increment count and continue checking.
5. Update the maximum length.

### Time Complexity
- **O(n²)** (because of nested linear search)

### Space Complexity
- **O(1)**

### Problem
- Extremely inefficient for large inputs.

---

## 2. Better Approach (Sorting)

### Idea
Sort the array so that consecutive elements come together.

### Steps
1. Sort the array.
2. Initialize:
   - `lastSmaller = Integer.MIN_VALUE`
   - `cnt = 0`
   - `longest = 1`
3. Traverse the array:
   - If `arr[i] - 1 == lastSmaller` → extend sequence (`cnt++`)
   - If `arr[i] == lastSmaller` → skip (duplicate)
   - Else → reset sequence (`cnt = 1`)
4. Update `longest` accordingly.

### Time Complexity
- **O(n log n)** (due to sorting)

### Space Complexity
- **O(1)** (if in-place sort)

### Drawback
- Modifies the original array (not always allowed or desirable).

---

## 3. Optimal Approach (HashSet)

### Idea
Use a **HashSet** to remove duplicates and allow O(1) lookups.

The key trick:
Only start counting when the current number is the **start of a sequence**  
(i.e., `x - 1` does NOT exist in the set)

### Steps
1. Insert all elements into a HashSet.
2. For each element `x` in the set:
   - Check if `x - 1` is NOT present → start of sequence
   - Initialize `count = 1`
   - Keep checking `x + 1`, `x + 2`, ... in the set
   - Increment count while elements exist
3. Track the maximum sequence length.

### Why this works
- Prevents re-counting sequences multiple times.
- Each sequence is processed only once.

### Time Complexity
- **O(n)** (average case)

### Space Complexity
- **O(n)** (for HashSet)

### Important Insight
If you skip the `x - 1` check, your solution degrades toward **O(n²)** behavior.

---

## Comparison

| Approach       | Time Complexity | Space Complexity | Notes |
|----------------|---------------|-----------------|------|
| Brute Force    | O(n²)          | O(1)            | Worst approach |
| Better (Sort)  | O(n log n)     | O(1)            | Modifies array |
| Optimal (Set)  | O(n)           | O(n)            | Best approach |

---

## Category
- Arrays
- Hashing (Core concept)
- Sequence / Pattern Recognition

---