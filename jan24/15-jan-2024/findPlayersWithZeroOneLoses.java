import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

package 15-jan-2024;

public class findPlayersWithZeroOneLoses {
    /*
     * Name Of The Problem :- 2225. Find Players With Zero or One Losses
     * Date :- 15-jan-2024
     * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

Return a list answer of size 2 where:

answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.

Note:

You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
 

Example 1:

Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
Example 2:

Input: matches = [[2,3],[1,3],[5,4],[6,4]]
Output: [[1,2,5,6],[]]
Explanation:
Players 1, 2, 5, and 6 have not lost any matches.
Players 3 and 4 each have lost two matches.
Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 

Constraints:

1 <= matches.length <= 105
matches[i].length == 2
1 <= winneri, loseri <= 105
winneri != loseri
All matches[i] are unique.
     */


     class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
             Map<Integer, Integer> lost = new HashMap<>();
    
            for (int[] it : matches) {
                int lose = it[1];
                lost.put(lose, lost.getOrDefault(lose, 0) + 1);
            }
    
            List<Integer> notLost = new ArrayList<>();
            List<Integer> oneLos = new ArrayList<>();
    
            for (int[] it : matches) {
                int lose = it[1];
                int win = it[0];
    
                if (lost.get(lose) == 1) {
                    oneLos.add(lose);
                }
                if (!lost.containsKey(win)) {
                    notLost.add(win);
                    lost.put(win, 2);
                }
            }
    
            Collections.sort(notLost);
            Collections.sort(oneLos);
    
            return Arrays.asList(notLost, oneLos);
            
        }
    }
    
}
