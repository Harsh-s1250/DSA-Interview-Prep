# Spiral Order Traversal of Matrix

## Problem
Given a 2D matrix, return all elements of the matrix in spiral order.

---

## Approach: Boundary Traversal (Simulation)

### Core Idea
Traverse the matrix layer by layer using four boundaries:
- top
- bottom
- left
- right

At each step, traverse one side of the current boundary and then shrink that boundary inward.

---

## Algorithm Steps

1. Initialize:
   - top = 0
   - bottom = number of rows - 1
   - left = 0
   - right = number of columns - 1

2. Repeat while:
   top <= bottom AND left <= right

3. Traverse in this exact order:

   a) Top Row (left → right)
      Add all elements from matrix[top][left → right]
      Then increment top

   b) Right Column (top → bottom)
      Add all elements from matrix[top → bottom][right]
      Then decrement right

   c) Bottom Row (right → left)
      Only if top <= bottom
      Add all elements from matrix[bottom][right → left]
      Then decrement bottom

   d) Left Column (bottom → top)
      Only if left <= right
      Add all elements from matrix[bottom → top][left]
      Then increment left

---

## Dry Run Example

Matrix:
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16

Spiral Order:
[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

---

## Time Complexity
O(n × m)

Reason:
Every element is visited exactly once.

---

## Space Complexity
O(1) auxiliary space  
O(n × m) output space (for result list)

---

## Key Observations
- This is a simulation problem, not an algorithm-heavy one.
- Correct boundary updates are more important than logic complexity.
- The order of traversal must not be changed.

---

## Common Mistakes

1. Missing boundary checks:
   - Forgetting `if (top <= bottom)` or `if (left <= right)` leads to duplicates.

2. Wrong traversal order:
   - Changing order breaks spiral pattern.

3. Off-by-one errors:
   - Incorrect loop conditions cause skipped or repeated elements.

4. Not updating boundaries correctly:
   - Leads to infinite loops or incorrect output.

---

## Category
Arrays → 2D Matrix → Traversal → Simulation (Boundary Control)

---

## When to Use This Pattern
- Spiral traversal
- Layer-by-layer matrix problems
- Boundary shrinking problems
