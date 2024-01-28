package jan24.28-jan-2024;

public class numberOfSubmatrices {

    Name Of The Problem :- 1074. Number of Submatrices That Sum to Target


    Date :- 28-jan-2024

    Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

 

Example 1:


Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
Example 3:

Input: matrix = [[904]], target = 0
Output: 0
 

Constraints:

1 <= matrix.length <= 100
1 <= matrix[0].length <= 100
-1000 <= matrix[i] <= 1000
-10^8 <= target <= 10^8


----------------------------------------------------------------------------------------


class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
         int rows = matrix.length; // m
        int cols = matrix[0].length; // n

        // First take the cumulative sum row-wise
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        // Now, find the "No. of subarrays with sum k" in the downward direction
        int result = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int currCol = startCol; currCol < cols; currCol++) {
                // We need to find all submatrices sum

                // Now comes the concept of "No. of subarrays with sum k"
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                // Go downwards row-wise
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return result;
        
    }
}
    
    
}
