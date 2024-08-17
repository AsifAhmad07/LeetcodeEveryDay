package 17-aug-2024;

public class maximumNumberofPointswithCost {


    Name Of The Problem :- 1937. Maximum Number of Points with Cost


    Date :- 17-August-2024

    You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0.
 

Example 1:


Input: points = [[1,2,3],[1,5,1],[3,1,1]]
Output: 9
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
You add 3 + 5 + 3 = 11 to your score.
However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
Your final score is 11 - 2 = 9.
Example 2:


Input: points = [[1,5],[2,3],[4,2]]
Output: 11
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
You add 5 + 3 + 4 = 12 to your score.
However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
Your final score is 12 - 1 = 11.
 

Constraints:

m == points.length
n == points[r].length
1 <= m, n <= 105
1 <= m * n <= 105
0 <= points[r][c] <= 105

*****************************************************************************************************************************************************
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prev = new long[n];

        // Initialize the first row
        for (int col = 0; col < n; col++) {
            prev[col] = points[0][col];
        }

        // Process each subsequent row
        for (int i = 1; i < m; i++) {
            long[] curr = new long[n];
            long[] left = new long[n];
            long[] right = new long[n];

            // Fill left array
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(prev[j], left[j - 1] - 1);
            }

            // Fill right array
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(prev[j], right[j + 1] - 1);
            }

            // Calculate current row's maximum points
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            // Update prev array for the next iteration
            prev = curr;
        }

        // Return the maximum value from the last row
        long max = Long.MIN_VALUE;
        for (long val : prev) {
            max = Math.max(max, val);
        }

        return max;
        
    }
}
    
}
