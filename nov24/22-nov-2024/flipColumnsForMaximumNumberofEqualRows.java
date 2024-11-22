package 22-nov-2024;

public class flipColumnsForMaximumNumberofEqualRows {



    Name Of The Problem :- 1072. Flip Columns For Maximum Number of Equal Rows


    Date :- 22-Novemebr-2024

    You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.

 

Example 1:

Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: matrix = [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is either 0 or 1.


*****************************************************************************************************************************************************

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {

         int n = matrix[0].length;
        int maxRows = 0;

        for (int[] currRow : matrix) {
            int[] inverted = new int[n];
            int count = 0;
            for (int col = 0; col < n; col++) {
                inverted[col] = currRow[col] == 0 ? 1 : 0;
            }
            for (int[] row : matrix) {
                if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
        
    }
}
    
}
