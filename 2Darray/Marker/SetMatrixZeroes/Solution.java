import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstrowzero = false;
        boolean firstcolzero = false;

        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstrowzero = true;
                break;
            }
        }

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstcolzero = true;
                break;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstrowzero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstcolzero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        Solution obj = new Solution();
        obj.setZeroes(matrix);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}