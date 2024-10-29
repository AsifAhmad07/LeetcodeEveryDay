package 29-oct-2024;

public class maximumNumberofMovesinaGrid {



    Name Of The Problem :- 2684. Maximum Number of Moves in a Grid

    Date :- 29-October-2024

    You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.

 

Example 1:


Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.
Example 2:


Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 105
1 <= grid[i][j] <= 106


*****************************************************************************************************************************************************


class Solution {
    int[][] dp;
    int n, m;

    public int f(int i, int j, int prev, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        int x = grid[i][j];
        if (x <= prev) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 1 + Math.max(Math.max(f(i - 1, j + 1, x, grid),
                                         f(i, j + 1, x, grid)),
                                f(i + 1, j + 1, x, grid));
        return dp[i][j];
    }

    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f(i, 0, -1, grid));
        }
        return ans - 1;
    }
}

    
}
