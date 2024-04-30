package 30-april-2024;

public class numberofWonderfulSubstrings {


    Name Of The Problem :- 1915. Number of Wonderful Substrings

    Date :- 30-April-2024

    A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: word = "aba"
Output: 4
Explanation: The four wonderful substrings are underlined below:
- "aba" -> "a"
- "aba" -> "b"
- "aba" -> "a"
- "aba" -> "aba"
Example 2:

Input: word = "aabb"
Output: 9
Explanation: The nine wonderful substrings are underlined below:
- "aabb" -> "a"
- "aabb" -> "aa"
- "aabb" -> "aab"
- "aabb" -> "aabb"
- "aabb" -> "a"
- "aabb" -> "abb"
- "aabb" -> "b"
- "aabb" -> "bb"
- "aabb" -> "b"
Example 3:

Input: word = "he"
Output: 2
Explanation: The two wonderful substrings are underlined below:
- "he" -> "h"
- "he" -> "e"
 

Constraints:

1 <= word.length <= 105
word consists of lowercase English letters from 'a' to 'j'.


*****************************************************************************************************************************************************consists

class Solution {
    public long wonderfulSubstrings(String word) {
           Map<Long, Long> mp = new HashMap<>();

        mp.put(0L, 1L);
        int cum_xor = 0;

        long result = 0;

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';

            cum_xor ^= (1 << shift);

            result += mp.getOrDefault((long) cum_xor, 0L);

            for (char ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';

                long check_xor = (cum_xor ^ (1 << shift));

                result += mp.getOrDefault(check_xor, 0L);
            }

            mp.put((long) cum_xor, mp.getOrDefault((long) cum_xor, 0L) + 1);
        }

        return result;
        
    }
}
    
}
