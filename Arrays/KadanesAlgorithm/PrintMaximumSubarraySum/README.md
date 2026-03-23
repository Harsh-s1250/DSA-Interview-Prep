# Maximum Subarray Sum (Kadane’s Algorithm with Subarray Printing)

## Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one element) which has the largest sum and return its sum. Also print that subarray.

---

## Approach

### Brute Force Approach
- Generate all possible subarrays.
- Calculate the sum of each subarray.
- Keep track of the maximum sum.

Time Complexity: O(n²)  
Space Complexity: O(1)

---

### Optimized Approach (Kadane’s Algorithm)

This approach finds the maximum subarray sum in a single traversal.

#### Key Idea
- Maintain a running sum.
- Reset sum when it becomes negative.
- Track start and end indices to print the subarray.

#### Steps
1. Initialize:
   - sum = 0
   - maxi = -infinity
   - start = 0, end = 0, tempStart = 0

2. Traverse the array:
   - Add current element to sum
   - If sum > maxi:
     - update maxi
     - update start = tempStart
     - update end = current index
   - If sum < 0:
     - reset sum = 0
     - tempStart = current index + 1

3. Subarray from start to end is the answer.

---

## Complexity Analysis

Time Complexity: O(n)  
Space Complexity: O(1)

---

## Edge Cases

1. All elements are negative  
   - The algorithm still returns the maximum element.

2. Single element array  
   - That element itself is the answer.

3. Multiple subarrays with same sum  
   - First occurring subarray is returned.

---

## Output

- Prints the subarray with maximum sum  
- Prints the maximum sum value