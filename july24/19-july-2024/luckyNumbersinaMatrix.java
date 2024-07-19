package 19-july-2024;

public class luckyNumbersinaMatrix {

    Name Of The Problem :- 1380. Lucky Numbers in a Matrix

    Date :- 19-July-2024

    Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.

*****************************************************************************************************************************************************

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int rMinMax = Integer.MIN_VALUE;

        for (int row = 0; row < m; row++) {
            int rMin = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }
            rMinMax = Math.max(rMinMax, rMin);
        }

        int cMaxMin = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            int cMax = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }
            cMaxMin = Math.min(cMaxMin, cMax);
        }

        List<Integer> result = new ArrayList<>();
        if (rMinMax == cMaxMin) {
            result.add(rMinMax); // {cMaxMin}
        }

        return result;
        
    }
}
    
}
