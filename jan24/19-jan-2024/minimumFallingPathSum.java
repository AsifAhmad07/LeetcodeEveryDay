public class minimumFallingPathSum {

    /*
     * Name Of The Problem :- 931. Minimum Falling Path Sum
     * Date :- 19-jan-2024
     * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
     * 
     * 
     * 
     */

     class Solution {
        public int minFallingPathSum(int[][]A) {
            int n = A.length;
            int[] prev = new int[n];
            
            // Initialize the first row of prev array
            for (int col = 0; col < n; col++) {
                prev[col] = A[0][col];
            }
            
            // Iterate over the remaining rows
            for (int row = 1; row < n; row++) {
                int[] curr = new int[n];
                for (int col = 0; col < n; col++) {
                    curr[col] = A[row][col] + Math.min(Math.min(prev[Math.max(0, col - 1)], prev[col]), prev[Math.min(n - 1, col + 1)]);
                }
                prev = curr;
            }
            
            // Return the minimum element in the last row of the dp array
            int minPathSum = Integer.MAX_VALUE;
            for (int value : prev) {
                minPathSum = Math.min(minPathSum, value);
            }
            
            return minPathSum;
            
        }
    }
}