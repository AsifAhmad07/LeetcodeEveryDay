package 20-april-2024;

public class findAllGroupsofFarmland {



    Name Of The Problem :- 1992. Find All Groups of Farmland


    Date :- 20-April-2024


    You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

 

Example 1:


Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:


Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
Example 3:


Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.
 

Constraints:

m == land.length
n == land[i].length
1 <= m, n <= 300
land consists of only 0's and 1's.
Groups of farmland are rectangular in shape.



*****************************************************************************************************************************************************a

class Solution {
    public int[][] findFarmland(int[][] land) {
        

          int m = land.length;
        int n = land[0].length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (land[i][j] == 0) continue;
                int c1 = j;
                while (c1 < n && land[i][c1] == 1) {
                    c1++;
                }
                int r1 = i;
                while (r1 < m && land[r1][j] == 1) {
                    r1++;
                }

                c1 = c1 == 0 ? c1 : c1 - 1;
                r1 = r1 == 0 ? r1 : r1 - 1;

                List<Integer> coordinates = new ArrayList<>();
                coordinates.add(i);
                coordinates.add(j);
                coordinates.add(r1);
                coordinates.add(c1);

                result.add(coordinates);
                for (int k = i; k <= r1; k++) {
                    for (int l = j; l <= c1; l++) {
                        land[k][l] = 0; 
                    }
                }
            }
        }

        int[][] resultArray = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 4; j++) {
                resultArray[i][j] = result.get(i).get(j);
            }
        }

        return resultArray;
    }
}
    
}
