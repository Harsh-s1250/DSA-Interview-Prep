import java.util.*;

class Solution {
    // Function to return matrix in spiral order
    public List spiralOrder(int[][] matrix) {
        // Result list to store the spiral order
        List result = new ArrayList<>();

        // Initialize boundaries
        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;   // Ending column

        // Loop until all elements are traversed
        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        // Input matrix
        int[][] matrix = {
            { 1,  2,  3,  4 },
            { 5,  6,  7,  8 },
            { 9, 10, 11, 12 },
            { 13,14, 15, 16 }
        };
        List ans = obj.spiralOrder(matrix);
        System.out.println(ans);
    }
}


