# Single Number

## Problem Statement
Given a non-empty array of integers `nums`, every element appears twice except for one.  
Find that single one.

---

## Example

Input:
nums = [4, 1, 2, 1, 2]

Output:
4

---

## Approach 1: Bit Manipulation (XOR) — Optimal

### Intuition
- XOR of a number with itself is 0 → a ^ a = 0  
- XOR of a number with 0 is the number itself → a ^ 0 = a  

All duplicate elements cancel out, leaving only the unique element.

---

### Algorithm
1. Initialize `xor = 0`
2. Traverse the array
3. XOR each element with `xor`
4. Return the final value

---

### Code

```java
import java.util.*;

public class SingleNumberXOR {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
```

---

### Complexity

- Time Complexity: O(n)  
- Space Complexity: O(1)

---

### Why This Approach
- No extra space required  
- Single pass solution  
- Efficient and optimal  

---

## Approach 2: HashMap (Frequency Counting)

### Intuition
Count the frequency of each element. The element with frequency 1 is the answer.

---

### Algorithm
1. Create a HashMap
2. Store frequency of each number
3. Find the element with frequency 1

---

### Code

```java
import java.util.*;

public class SingleNumberHashMap {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}
```

---

### Complexity

- Time Complexity: O(n)  
- Space Complexity: O(n)

---

### Limitations
- Uses extra space  
- Less efficient compared to XOR  

---

## Key Takeaways

- XOR is the optimal solution for this pattern  
- HashMap is a fallback approach  
- This problem belongs to Bit Manipulation