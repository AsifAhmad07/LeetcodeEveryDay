package 18-jan-2025;

public class minimumCosttoMakeatLeastOneValidPathinaGrid {


    Name Of The Problem :- 1368. Minimum Cost to Make at Least One Valid Path in a Grid

    Date :-  18-January-2025

    Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

 

Example 1:


Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.
Example 2:


Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
Output: 0
Explanation: You can follow the path from (0, 0) to (2, 2).
Example 3:


Input: grid = [[1,2],[4,3]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
1 <= grid[i][j] <= 4

*****************************************************************************************************************************************************

class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0, 0});
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int i = current[0];
            int j = current[1];
            int currentCost = current[2];
            if (i == m - 1 && j == n - 1) {
                return currentCost;
            }
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newCost = currentCost + (grid[i][j] == d + 1 ? 0 : 1);

                    if (newCost < cost[ni][nj]) {
                        cost[ni][nj] = newCost;
                        if (grid[i][j] == d + 1) {
                            deque.offerFirst(new int[]{ni, nj, newCost});
                        } else {
                            deque.offerLast(new int[]{ni, nj, newCost});
                        }
                    }
                }
            }
        }

        return -1; 
    }
}
    
}
