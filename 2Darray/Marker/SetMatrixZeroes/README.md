# Set Matrix Zeroes

## Problem
Given an `m x n` matrix, if an element is 0, set its entire row and column to 0.  
You must do it **in-place**.

---

## 1. Brute Force Approach

### Idea
Whenever a cell is 0, mark its entire row and column as 0.

### Steps
1. Traverse the matrix.
2. Whenever you find `matrix[i][j] == 0`:
   - Mark all elements in row `i`
   - Mark all elements in column `j`
3. Use a temporary matrix to avoid overwriting original values.

### Time Complexity
- **O((m × n) × (m + n))**

### Space Complexity
- **O(m × n)**

### Problem
- Uses extra space
- Inefficient due to repeated marking

---

## 2. Better Approach

### Idea
Instead of modifying immediately, store which rows and columns need to be zeroed.

### Steps
1. Create two arrays:
   - `row[m]` → marks rows to be zero
   - `col[n]` → marks columns to be zero
2. Traverse matrix:
   - If `matrix[i][j] == 0`, mark:
     - `row[i] = 1`
     - `col[j] = 1`
3. Traverse again:
   - If `row[i] == 1` or `col[j] == 1`, set `matrix[i][j] = 0`

### Time Complexity
- **O(m × n)**

### Space Complexity
- **O(m + n)**

### Drawback
- Still uses extra space

---

## 3. Optimal Approach (In-place Marker Technique)

### Idea
Use the **first row and first column as markers** instead of extra arrays.

### Key Insight
- `matrix[i][0]` → marks whether row `i` should be zero
- `matrix[0][j]` → marks whether column `j` should be zero

Problem: first row and column overlap → handle separately using flags

---

### Steps
1. Check if first row contains zero → `firstRowZero`
2. Check if first column contains zero → `firstColZero`

3. Traverse matrix (excluding first row & column):
   - If `matrix[i][j] == 0`:
     - mark `matrix[i][0] = 0`
     - mark `matrix[0][j] = 0`

4. Traverse again:
   - If `matrix[i][0] == 0` OR `matrix[0][j] == 0`
     → set `matrix[i][j] = 0`

5. Handle first row and column separately:
   - If `firstRowZero` → make entire first row zero
   - If `firstColZero` → make entire first column zero

---

### Time Complexity
- **O(m × n)**

### Space Complexity
- **O(1)**

---

## Comparison

| Approach       | Time Complexity        | Space Complexity | Notes |
|----------------|----------------------|------------------|------|
| Brute Force    | O((m×n)(m+n))         | O(m×n)           | Inefficient |
| Better         | O(m×n)                | O(m+n)           | Uses extra arrays |
| Optimal        | O(m×n)                | O(1)             | Best approach |

---

## Category

- Arrays (2D Matrix)
- In-place Algorithm
- Space Optimization
- Marker Technique (Core Pattern)

---

## Key Takeaway

This problem is not about matrices.  
It is about:

**Using given input as storage to eliminate extra space**

---