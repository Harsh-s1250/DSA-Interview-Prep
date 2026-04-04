# Rotate Matrix by 90 Degrees

## Problem
Given an n x n 2D matrix, rotate the matrix by 90 degrees clockwise.

---

## Approach 1: Using Extra Array (Brute Force)

### Idea
Create a new matrix `ans[][]` and place elements in their rotated positions.

### Mapping Logic
matrix[i][j] → ans[j][n - 1 - i]

### Steps
1. Initialize a new matrix `ans[n][n]`
2. Traverse the original matrix
3. Place each element in its rotated position in `ans`
4. Copy `ans` back to the original matrix (if required)

### Time Complexity
O(n^2)

### Space Complexity
O(n^2)

### Pros
- Simple and intuitive
- Easy to implement

### Cons
- Uses extra space
- Not optimal for in-place constraints

---

## Approach 2: Optimal (In-place)

### Core Idea
Rotation = Transpose + Reverse Rows

### Step 1: Transpose the Matrix
Swap elements across the diagonal:
matrix[i][j] ↔ matrix[j][i]

### Step 2: Reverse Each Row
Reverse every row of the matrix

### Steps
1. Traverse only the upper triangle of the matrix and swap elements
2. Reverse each row

### Time Complexity
O(n^2)

### Space Complexity
O(1)

### Pros
- No extra space required
- Preferred in interviews

---

## Common Mistakes
- Confusing clockwise and anti-clockwise rotation
- Applying reverse before transpose
- Incorrect index mapping in brute force approach

---

## Variations
- Anti-clockwise rotation:
  Transpose + Reverse columns

- 180 degree rotation:
  Reverse rows + Reverse columns

---

## Category
- Arrays
- 2D Matrix
- In-place manipulation
- Pattern-based transformation
