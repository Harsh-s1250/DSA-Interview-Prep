# Rearrange Array by Sign

## Problem Statement
Given an array of integers, rearrange the elements such that positive and negative numbers are placed alternately.

### Note:
- In some versions, the number of positive and negative elements is equal.
- In general cases, they may not be equal.

---

# Approach 1: Direct Index Placement (Optimized Approach)

## Idea
Place positive elements at even indices (0, 2, 4, ...)  
Place negative elements at odd indices (1, 3, 5, ...)

## Algorithm
1. Create a result array of same size.
2. Maintain two pointers:
   - `pos = 0` (for positive numbers)
   - `neg = 1` (for negative numbers)
3. Traverse the array:
   - If element is positive → place at `pos`, increment `pos += 2`
   - If element is negative → place at `neg`, increment `neg += 2`
4. Return the result array.

## Code
```java
public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n];
    int pos = 0, neg = 1;

    for (int i = 0; i < n; i++) {
        if (nums[i] < 0) {
            arr[neg] = nums[i];
            neg += 2;
        } else {
            arr[pos] = nums[i];
            pos += 2;
        }
    }
    return arr;
}
```

## Complexity
- Time: O(n)
- Space: O(n)

## Limitation
- Works **only when number of positive and negative elements are equal**
- Can cause **ArrayIndexOutOfBoundsException** if counts are unequal

---

# Approach 2: Brute Force (Using Two Temporary Arrays)

## Idea
Separate positive and negative elements first, then merge them alternately.

## Algorithm
1. Traverse the array and store:
   - Positives in `posList`
   - Negatives in `negList`
2. Create result array.
3. Merge both lists alternately:
   - Add one positive, then one negative
4. If any elements remain in either list, append them at the end.

## Code
```java
import java.util.*;

public int[] rearrangeArray(int[] nums) {
    List<Integer> posList = new ArrayList<>();
    List<Integer> negList = new ArrayList<>();

    for (int num : nums) {
        if (num >= 0) {
            posList.add(num);
        } else {
            negList.add(num);
        }
    }

    int i = 0, j = 0, k = 0;
    int[] result = new int[nums.length];

    while (i < posList.size() && j < negList.size()) {
        result[k++] = posList.get(i++);
        result[k++] = negList.get(j++);
    }

    while (i < posList.size()) {
        result[k++] = posList.get(i++);
    }

    while (j < negList.size()) {
        result[k++] = negList.get(j++);
    }

    return result;
}
```

## Complexity
- Time: O(n)
- Space: O(n)

## Advantages
- Works for **all cases (equal or unequal positives/negatives)**
- No risk of index overflow

## Disadvantages
- Uses extra space for temporary lists

---

# Comparison

| Feature                     | Direct Placement | Two Arrays (Brute Force)  |
|-----------------------------|------------------|---------------------------|
| Time Complexity             | O(n)             | O(n)                      |
| Space Complexity            | O(n)             | O(n)                      |
| Handles unequal counts      | No               | Yes                       |
| Risk of runtime error       | Yes              | No                        |
| Simplicity                  | Simple           | Simple                    |

---

# Conclusion

- Use **Direct Placement** only when equal positives and negatives are guaranteed.
- Use **Two Array Approach** when input is unpredictable.
