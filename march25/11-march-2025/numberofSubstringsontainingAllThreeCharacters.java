package 11-march-2025;

public class numberofSubstringsontainingAllThreeCharacters {


    Name Of The Problem :- 1358. Number of Substrings Containing All Three Characters

    Date :- 11-March-2025

    Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.



*****************************************************************************************************************************************************

class Solution {
    public int numberOfSubstrings(String s) {

         int n = s.length();
        int result = 0;
        int[] mp = new int[3]; 
        
        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            mp[ch - 'a']++;
            
            while (mp[0] > 0 && mp[1] > 0 && mp[2] > 0) {
                result += (n - j);
                mp[s.charAt(i) - 'a']--;
                i++;
            }
            
            j++;
        }
        
        return result;
        
    }
}
    
}
