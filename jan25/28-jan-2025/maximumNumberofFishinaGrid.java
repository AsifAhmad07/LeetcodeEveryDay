package 28-jan-2025;

public class maximumNumberofFishinaGrid {


    Name Of The Problem :_ 2658. Maximum Number of Fish in a Grid

    Date :- 28-January-2025

    You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

 

Example 1:


Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
0 <= grid[i][j] <= 10



*****************************************************************************************************************************************************

class DSU {
    private int[] parent;
    private int[] size;

    public DSU(int n) { 
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 0; 
        }
    }
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]); 
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) { 
            return;
        }

        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }
    }

    public void setSize(int x, int fishCount) {
        size[x] = fishCount;
    }

    public int getMaxFishCount() {
        int maxFish = 0;
        for (int fish : size) {
            maxFish = Math.max(maxFish, fish);
        }
        return maxFish;
    }
}

class Solution {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int totalCells = m * n;
        DSU dsu = new DSU(totalCells);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int idx = i * n + j;
                    dsu.setSize(idx, grid[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int idx = i * n + j; 
                    for (int[] dir : directions) {
                        int i_ = i + dir[0];
                        int j_ = j + dir[1];
                        if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && grid[i_][j_] > 0) {
                            int idx_ = i_ * n + j_;
                            dsu.union(idx, idx_);
                        }
                    }
                }
            }
        }

        return dsu.getMaxFishCount();
    }
}
    
}
