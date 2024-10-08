package 05-oct-2024;

public class permutationinString {


    Name Of The Problem :- 567. Permutation in String

    Date :- 05-October-2024

    Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    public boolean checkInclusion(String s1, String s2) {

         int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);
        for (int i = 0; i <= m - n; i++) {
            String temp = s2.substring(i, i + n);
            char[] sortedTemp = temp.toCharArray();
            Arrays.sort(sortedTemp);
            if (Arrays.equals(sortedTemp, sortedS1)) return true;
        }
        return false;
        
    }
}
    
}
