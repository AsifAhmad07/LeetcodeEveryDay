package 26-april-2024;

public class minimumFallingPathSumII {


    Name Of The Problem :- 1289. Minimum Falling Path Sum II


Date :- 26-April-2024

Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99

*****************************************************************************************************************************************************

class Solution {
    public int minFallingPathSum(int[][] grid) {
         int n = grid.length;

        int[][] t = new int[n][n];
        for (int[] row : t) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int col = 0; col < n; col++) {
            t[n - 1][col] = grid[n - 1][col];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int ans = Integer.MAX_VALUE;
                for (int nextCol = 0; nextCol < n; nextCol++) {
                    if (nextCol != col) {
                        ans = Math.min(ans, t[row + 1][nextCol]);
                    }
                }
                t[row][col] = grid[row][col] + ans;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, t[0][col]);
        }

        return result;
        
    }
}
    
}
