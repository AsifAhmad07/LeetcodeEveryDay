package 03-april-2024;

public class wordSearch {


    Name Of The Problem :- 79. Word Search

    Date :- 03-April-2024


    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    int l, m, n;
    List<List<Integer>> directions = new ArrayList<>();
    
    public Solution() {
        directions.add(List.of(0, 1));
        directions.add(List.of(0, -1));
        directions.add(List.of(1, 0));
        directions.add(List.of(-1, 0));
    }
    
    public boolean find(char[][] board, int i, int j, String word, int idx) {
        if(idx >= l)
            return true;
        
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx))
            return false;
        
        char temp = board[i][j];
        board[i][j] = '$';
        
        for(List<Integer> dir : directions) {
            int i_ = i + dir.get(0);
            int j_ = j + dir.get(1);
            
            if(find(board, i_, j_, word, idx+1))
                return true;
        }
        
        board[i][j] = temp;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();
        if(m*n < l)
            return false;
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == word.charAt(0) && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

    
}
