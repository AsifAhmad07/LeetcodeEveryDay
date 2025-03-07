package 25-nov-2024;

public class slidingPuzzle {

    Name Of The Problem :- 773. Sliding Puzzle

    Date :- 25-Novemebr-2024

    On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

 

Example 1:


Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Example 2:


Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Example 3:


Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
 

Constraints:

board.length == 2
board[i].length == 3
0 <= board[i][j] <= 5
Each value board[i][j] is unique.


*****************************************************************************************************************************************************

class Solution {
    public int slidingPuzzle(int[][] board) {

         StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }
        
        String target = "123450";
        Map<Integer, int[]> mp = new HashMap<>();
        mp.put(0, new int[]{1, 3});
        mp.put(1, new int[]{0, 2, 4});
        mp.put(2, new int[]{1, 5});
        mp.put(3, new int[]{0, 4});
        mp.put(4, new int[]{1, 3, 5});
        mp.put(5, new int[]{2, 4});
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());
        
        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        
        int level = 0; 
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return level;
                }
                
                int indexOfZero = curr.indexOf('0'); 
                for (int swapIdx : mp.get(indexOfZero)) {
                    char[] newStateArray = curr.toCharArray();
                    char temp = newStateArray[indexOfZero];
                    newStateArray[indexOfZero] = newStateArray[swapIdx];
                    newStateArray[swapIdx] = temp;
                    
                    String newState = new String(newStateArray);
                    if (!visited.contains(newState)) {
                        queue.offer(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }
        
        return -1;
        
    }
}
    
}
