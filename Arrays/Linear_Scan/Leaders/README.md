# Leaders in an Array

## Problem
Given an array `nums`, find all **leaders** in the array.

An element is called a **leader** if it is **greater than all elements to its right**.  
The **rightmost element is always a leader**.

---

## Example
Input:  [10, 22, 12, 3, 0, 6]  
Output: [22, 12, 6]

---

## Brute Force Approach (Nested Loops)

### Idea
For every element, check all elements to its right.  
If no element on the right is greater, then it is a leader.

---

### Steps
1. Iterate through each element `i`.
2. For each `i`, check all elements `j > i`.
3. If any `nums[j] > nums[i]`, then it is **not a leader**.
4. Otherwise, add it to the result.

---

### Code
ArrayList<Integer> leaders(int[] nums) {
    ArrayList<Integer> ans = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        boolean isLeader = true;

        for (int j = i + 1; j < n; j++) {
            if (nums[j] > nums[i]) {
                isLeader = false;
                break;
            }
        }

        if (isLeader) {
            ans.add(nums[i]);
        }
    }

    return ans;
}

---

### Time Complexity
- O(n²)

### Space Complexity
- O(1) (excluding result)

---

### Why this is bad
- Repeated comparisons for every element.
- Does unnecessary work.
- Not scalable for large inputs.

---

## Optimized Approach (Right Traversal + Suffix Maximum)

### Core Idea
Keep track of the **maximum element seen so far from the right**.

---

### Steps
1. Start from the **last element** → always a leader.
2. Initialize `max` with last element.
3. Traverse from right to left:
   - If `nums[i] > max`, it is a leader.
   - Update `max`.
4. Reverse the result to maintain original order.

---

### Code
public ArrayList<Integer> leaders(int[] nums) {
    ArrayList<Integer> ans = new ArrayList<>();
    
    if (nums.length == 0) {
        return ans;
    }
    
    int max = nums[nums.length - 1];
    ans.add(nums[nums.length - 1]);
    
    for (int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] > max) {
            ans.add(nums[i]);
            max = nums[i];
        }
    }
    
    Collections.reverse(ans);
    return ans;
}

---

### Time Complexity
- O(n)

### Space Complexity
- O(1) (excluding result)

---

## Why This Works
- `max` always stores the maximum element to the right.
- Each element is compared only once.
- Eliminates redundant checks.

---

## Key Observations
- Last element is always a leader.
- Right-to-left traversal is necessary.
- No sorting required.

---

## Category
- Array
- Greedy
- Suffix Maximum Pattern

---

## Final Comparison

| Approach        | Time Complexity | Practical? |
|----------------|----------------|-----------|
| Brute Force    | O(n²)          | ❌ No      |
| Optimized      | O(n)           | ✅ Yes     |

---