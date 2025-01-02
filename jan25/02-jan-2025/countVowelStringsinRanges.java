import java.util.jar.Attributes.Name;

package 02-jan-2025;

public class countVowelStringsinRanges {


    Name Of The Problem :- 2559. Count Vowel Strings in Ranges

    Date :- 02-January-2024

    You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].
Example 2:

Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].
 

Constraints:

1 <= words.length <= 105
1 <= words[i].length <= 40
words[i] consists only of lowercase English letters.
sum(words[i].length) <= 3 * 105
1 <= queries.length <= 105
0 <= li <= ri < words.length


*****************************************************************************************************************************************************

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
         int N = words.length;
        int Q = queries.length;
        int[] result = new int[Q];
        int[] cumSum = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }
            cumSum[i] = sum;
        }
        for (int i = 0; i < Q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }
        
        return result;
        
    }
     private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
     }
}
    
}
