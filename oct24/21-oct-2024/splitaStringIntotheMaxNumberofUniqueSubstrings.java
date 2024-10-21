package 21-oct-2024;

public class splitaStringIntotheMaxNumberofUniqueSubstrings {


    Name Of The Problem :- 1593. Split a String Into the Max Number of Unique Substrings

    Date :- 21-October-2024

    Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 

Constraints:

1 <= s.length <= 16

s contains only lower case English letters.


*****************************************************************************************************************************************************


class Solution {
    
    private void solve(String s, int idx, HashSet<String> st, int currCount, int[] maxCount) {
        if(currCount + (s.length() - idx) <= maxCount[0]) {
            return;
        }

        if (idx == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currCount);
            return;
        }

        for (int j = idx; j < s.length(); j++) {
            String sub = s.substring(idx, j + 1);
            if (!st.contains(sub)) {
                st.add(sub);
                solve(s, j + 1, st, currCount + 1, maxCount);
                st.remove(sub);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        HashSet<String> st = new HashSet<>();
        int[] maxCount = new int[1]; 
        solve(s, 0, st, 0, maxCount);
        return maxCount[0];
    }
}
    
}
