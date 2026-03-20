# 📘 Find Missing Number

## Problem Statement
Given an array containing `n` distinct numbers taken from the range `[0, n]`, find the **missing number**.

---

## Example

Input:
arr = [3, 0, 1]

Output:
2

---

# Approach 1: Mathematical Formula (Optimal & Simple)

## Intuition
- The sum of first `n` natural numbers is:
  
  sum = n * (n + 1) / 2

- Calculate expected sum and subtract actual sum of array
- The difference is the missing number

---

## Algorithm
1. Compute expected sum using formula
2. Compute actual sum of array
3. Return difference

---

## Code

```java
public class MissingNumberMath {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(findMissing(arr));
    }

    public static int findMissing(int[] arr) {
        int n = arr.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
```

---

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

---

## Limitation
- Can cause **integer overflow** for large `n`
- Example: when `n` is very large, `n * (n + 1)` may exceed `int` limit

---

# Approach 2: XOR (Best for Interviews)

## Intuition
- XOR of a number with itself = 0
- XOR of a number with 0 = number

So:
- XOR all array elements
- XOR with numbers from `0` to `n`
- All numbers cancel out except the missing one

---

## Algorithm
1. Initialize xor = 0
2. XOR all array elements
3. XOR with numbers from 0 to n
4. Result is missing number

---

## Code

```java
public class MissingNumberXOR {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(findMissing(arr));
    }

    public static int findMissing(int[] arr) {
        int n = arr.length;

        int xor = 0;

        // XOR all array elements
        for (int num : arr) {
            xor ^= num;
        }

        // XOR with 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        return xor;
    }
}
```

---

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

---

## Why XOR is Better

- No risk of overflow
- Cleaner logic for large inputs
- Preferred in interviews

---

# Common Mistakes

- Forgetting range is `[0, n]`
- Using wrong formula
- Integer overflow in math approach
- Off-by-one errors in XOR loop

---

# Key Takeaways

- Math approach = simple but risky (overflow)
- XOR approach = safer and interview-friendly
- Always understand the pattern, not just code