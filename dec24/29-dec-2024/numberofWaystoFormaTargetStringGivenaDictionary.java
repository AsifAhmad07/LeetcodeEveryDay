package 29-dec-2024;

public class numberofWaystoFormaTargetStringGivenaDictionary {


    Name Of The Problem :- 1639. Number of Ways to Form a Target String Given a Dictionary

    Date :- 29-December-2024

    You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
Example 2:

Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 1000
All strings in words have the same length.
1 <= target.length <= 1000
words[i] and target contain only lowercase English letters.



*****************************************************************************************************************************************************


class Solution {
    private int[][] dp;
    private int sol(int[][] f, int i, int j, String[] v, String t) 
    {
        if (i >= t.length())
            return 1; 
        if (j >= f.length)
            return 0; 
        if (dp[i][j] != -1)
            return dp[i][j];
        long ans = 0;
        ans = sol(f, i, j + 1, v, t) % (long)(1e9+7);
        long tmp = f[j][t.charAt(i) - 'a'];
        if (tmp > 0)
            ans = (ans + (sol(f, i + 1, j + 1, v, t) * tmp) % (long)(1e9+7)) % (long)(1e9+7);
        dp[i][j] = (int)(ans%(long)(1e9+7));
        return dp[i][j];
    }
    public int numWays(String[] v, String t) 
    {
        int n = t.length();
        int m = v[0].length();
        dp = new int[n + 1][m + 1];
        for (int[] r : dp) 
            Arrays.fill(r, -1);
        int[][] f = new int[m][26];
        for (int j = 0; j < m; j++) 
        {
            for (String s : v)
                f[j][s.charAt(j) - 'a']++;
        }
        return sol(f, 0, 0, v, t);
    }
}
    
}
