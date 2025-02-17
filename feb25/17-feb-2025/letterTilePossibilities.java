package 17-feb-2025;

public class letterTilePossibilities {


    Name Of The Problem :- 1079. Letter Tile Possibilities

    Date :- 17-February-2025

    You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.


*****************************************************************************************************************************************************

class Solution {
    private int total;

    private void findSequences(int[] count) {
        total++;

        for (int pos = 0; pos < 26; pos++) {
            if (count[pos] == 0) {
                continue;
            }

            count[pos]--;
            findSequences(count);
            count[pos]++;
        }
    }

    public int numTilePossibilities(String tiles) {
        total = 0;

        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }

        findSequences(count);
        return total - 1;
    }
}
    
}
