package 23-nov-2024;

public class rotatingtheBox {


    Name Of The Problem :- 1861. Rotating the Box

    Date :- 23-Novemebr-2024

    You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:



Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:



Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:



Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]
 

Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'.


*****************************************************************************************************************************************************

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(result[i]);
        }
        for (int j = 0; j < m; j++) {
            int spaceBottomRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    spaceBottomRow = i - 1;
                    continue;
                }

                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[spaceBottomRow][j] = '#';
                    spaceBottomRow--;
                }
            }
        }

        return result;
    }
    private void reverseRow(char[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
    
}
