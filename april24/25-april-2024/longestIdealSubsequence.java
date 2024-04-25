package 25-april-2024;

public class longestIdealSubsequence {


    Name Of The Problem :- 2370. Longest Ideal Subsequence

    Date :- 25-April-2024

    You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.

 

Example 1:

Input: s = "acfgbd", k = 2
Output: 4
Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
Example 2:

Input: s = "abcd", k = 3
Output: 4
Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 

Constraints:

1 <= s.length <= 105
0 <= k <= 25
s consists of lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        int[] t = new int[26];
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            
            int curr = s.charAt(i) - 'a';
            int left = Math.max(0, curr - k);
            int right = Math.min(25, curr + k);

            int longest = 0;
            for(int j = left; j <= right; j++) {
                longest = Math.max(longest, t[j]);
            }
            
            t[curr] = Math.max(t[curr], longest + 1);
            result = Math.max(result, t[curr]);
        }
        
        return result;
        
    }
}
  
}
