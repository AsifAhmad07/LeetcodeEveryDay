package 25-jan-2024;

public class longestCommonSubsequences {
    /*
     * Name Of The Problem :- 1143. Longest Common Subsequence
     * Date :- 25-jan-2024
     * 
     * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
     */
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
             int m = text1.length();
            int n = text2.length();
            
            int[][] t = new int[2][n+1];
            
            for (int i = 0; i < m+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    if (i == 0 || j == 0)
                        t[i%2][j] = 0;
                    else if (text1.charAt(i-1) == text2.charAt(j-1))
                        t[i%2][j] = 1 + t[(i+1)%2][j-1];
                    else
                        t[i%2][j] = Math.max(t[i%2][j-1], t[(i+1)%2][j]);
                }
            }
            
            return t[m%2][n];
            
        }
    }
    
}
