package 10-aug-2024;

public class regionsCutBySlashes {


    Name Of The Problem :- 959. Regions Cut By Slashes


    Date :- 10-August-2024

    An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

 

Example 1:


Input: grid = [" /","/ "]
Output: 2
Example 2:


Input: grid = [" /","  "]
Output: 1
Example 3:


Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 30
grid[i][j] is either '/', '\', or ' '.



*****************************************************************************************************************************************************


class Solution {
    // Directions array for moving up, down, left, and right
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // DFS method to explore the grid and mark visited cells
    private void numberOfIslandsDFS(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 1) {
            return;
        }

        matrix[i][j] = 1; // mark visited

        // Explore all four directions
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            numberOfIslandsDFS(matrix, new_i, new_j);
        }
    }

    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        int regions = 0;

        // Create a 3x3 expanded grid to handle slashes
        int[][] matrix = new int[rows * 3][cols * 3];

        // Populate the matrix based on '/' and '\\' in the original grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        // Apply DFS to count the regions
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    numberOfIslandsDFS(matrix, i, j);
                    regions++;
                }
            }
        }

        return regions;
    }
}
    
}