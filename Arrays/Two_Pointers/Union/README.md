# Union of Two Sorted Arrays

## Problem Statement
Given two **sorted arrays**, return their **union** (all unique elements in sorted order).

---

## Example

Input:
arr1 = [1, 2, 2, 3, 5]  
arr2 = [2, 3, 4, 5, 6]  

Output:
[1, 2, 3, 4, 5, 6]

---

# Approach 1: Two Pointer (Optimal)

## Intuition
Since arrays are sorted:
- Use two pointers
- Compare elements
- Add smaller element
- Move pointers
- Avoid duplicates

---

## Algorithm
1. Initialize pointers i = 0, j = 0
2. Compare arr1[i] and arr2[j]
3. Add smaller value (or one if equal)
4. Skip duplicates
5. Add remaining elements

---

## Code

```java
import java.util.*;

public class UnionTwoPointer {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {2, 3, 4, 5, 6};

        List<Integer> result = findUnion(arr1, arr2);
        System.out.println(result);
    }

    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            int val;

            if (arr1[i] < arr2[j]) {
                val = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            } else {
                val = arr1[i];
                i++;
                j++;
            }

            if (union.isEmpty() || union.get(union.size() - 1) != val) {
                union.add(val);
            }
        }

        while (i < arr1.length) {
            int val = arr1[i++];
            if (union.isEmpty() || union.get(union.size() - 1) != val) {
                union.add(val);
            }
        }

        while (j < arr2.length) {
            int val = arr2[j++];
            if (union.isEmpty() || union.get(union.size() - 1) != val) {
                union.add(val);
            }
        }

        return union;
    }
}
```

---

## Complexity

- Time Complexity: O(n + m)
- Space Complexity: O(n + m)

---

## Why This is Best
- Uses sorted property
- No extra sorting
- Linear time

---

#  Approach 2: Using Set

## Intuition
- Add all elements to a set
- Convert to list
- Sort result

---

## Code

```java
import java.util.*;

public class UnionUsingSet {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {2, 3, 4, 5, 6};

        List<Integer> result = findUnion(arr1, arr2);
        System.out.println(result);
    }

    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);

        return result;
    }
}
```

---

## Complexity

- Time Complexity: O((n + m) log(n + m))
- Space Complexity: O(n + m)

---

## Why This is Worse
- Ignores sorted property
- Extra sorting required
- Not optimal for interviews

---

# Key Takeaways

- Sorted array → use two pointers
- Always remove duplicates
- Prefer optimal approach over easy one