package 14-may-2024;

public class pathwithMaximumGold {


    Name Of The Problem :- 1219. Path with Maximum Gold

    Date :- 14-May-2024

    In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.

*****************************************************************************************************************************************************


class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int DFS(int[][] grid, int i, int j) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            return 0; //Zero gold
        }

        int originalGoldValue = grid[i][j];
        grid[i][j] = 0;

        int maxGold = 0;

        //up, down, left, right
        for(int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            maxGold = Math.max(maxGold, DFS(grid, new_i, new_j));
        }

        grid[i][j] = originalGoldValue;
        return originalGoldValue + maxGold;
    }
    
    public int getMaximumGold(int[][] grid) {
         m = grid.length;
        n = grid[0].length;

        int maxGold = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    //It has gold
                    maxGold = Math.max(maxGold, DFS(grid, i, j));
                }
            }
        }

        return maxGold;
        
    }
}
    
}
