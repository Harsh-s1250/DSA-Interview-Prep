# Subarray Sum Equals K

## Problem Statement
Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals k.

---

## Approach 1: Brute Force (Nested Loops)

### Idea
Check every possible subarray and calculate its sum.

### Algorithm
1. Start from each index i
2. Keep adding elements from i to j
3. If sum equals k, increment count

### Code
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

### Complexity
- Time: O(n²)
- Space: O(1)

## Problems
- Too slow for large inputs (n up to 10^5 → TLE)
- Not practical in interviews

---

## Approach 2: Prefix Sum + HashMap (Optimal)

### Idea
Use prefix sums and store their frequency to avoid recomputation.

### Key Concept
prefixSum[j] - prefixSum[i] = k  
⇒ prefixSum[i] = prefixSum[j] - k

### Algorithm
1. Maintain a running prefixSum
2. Use a HashMap to store frequency of prefix sums
3. At each step:
   - Check if (prefixSum - k) exists in map
   - Add its frequency to count
4. Update map with current prefixSum

### Code
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int remove = prefixSum - k;

            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            prefixSumCount.put(prefixSum, 
                prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

### Complexity
- Time: O(n)
- Space: O(n)

---

## Critical Points

- prefixSumCount.put(0,1) is mandatory  
- Works with negative numbers  
- Sliding window does NOT work here  
- Handles overlapping subarrays  

---

## Comparison

| Feature                | Brute Force | HashMap |
|----------------------|------------|--------|
| Time Complexity      | O(n²)      | O(n)   |
| Space Complexity     | O(1)       | O(n)   |
| Handles Negatives    | Yes        | Yes    |
| Efficient for Large n| No         | Yes    |

---

## When to Use

- Brute Force → only for learning  
- HashMap → interviews + real problems  

---

## Example

Input: nums = [1, -1, 0], k = 0  
Output: 3  

Explanation:
[1, -1]  
[0]  
[1, -1, 0]