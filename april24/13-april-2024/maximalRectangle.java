package 13-april-2024;

public class maximalRectangle {



    Name Of The Problem :- 85. Maximal Rectangle


    Date :- 13-April-2024

    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int MAH(int[] heights, int n) {
       Stack<Integer> st = new Stack<>();
       int i = 0;
       int maxArea = 0;
       int area = 0;
       while (i < n) {
           if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
               st.push(i++);
           } else {
               int index = st.pop();

               if (st.isEmpty()) {
                   area = heights[index] * i;
               } else {
                   area = heights[index] * (i - st.peek() - 1);
               }

               maxArea = Math.max(maxArea, area);
           }
       }

       while (!st.isEmpty()) {
           int index = st.pop();

           if (st.isEmpty()) {
               area = heights[index] * i;
           } else {
               area = heights[index] * (i - st.peek() - 1);
           }

           maxArea = Math.max(maxArea, area);
       }

       return maxArea;

   }

   public int maximalRectangle(char[][] matrix) {
       if (matrix.length == 0)
           return 0;

       int maxArea = 0;
       int m = matrix.length;
       int n = matrix[0].length;

       int[] heights = new int[n];
       for (int col = 0; col < n; col++) {
           heights[col] = matrix[0][col] == '0' ? 0 : 1;
       }

       maxArea = MAH(heights, n);

       for (int row = 1; row < m; row++) {
           for (int col = 0; col < n; col++) {
               if (matrix[row][col] == '0') {
                   heights[col] = 0;
               } else {
                   heights[col] += 1;
               }
           }

           maxArea = Math.max(maxArea, MAH(heights, n));
       }

       return maxArea;
   }
       
   
}
    
}
