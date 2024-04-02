import java.util.jar.Attributes.Name;

package 02-april-2024;

public class isomorphicStrings {

    Name Of The Problem :- 205. Isomorphic Strings

    Date :- 02-April-2024

    Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.



-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public boolean isIsomorphic(String s, String t) {
         int[] mp1 = new int[256];
        int[] mp2 = new int[256];
        Arrays.fill(mp1, -1);
        Arrays.fill(mp2, -1);
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if ((mp1[ch1] != -1 && mp1[ch1] != ch2) || (mp2[ch2] != -1 && mp2[ch2] != ch1))
                return false;
            
            mp1[ch1] = ch2;
            mp2[ch2] = ch1;
        }
        
        return true;
        
    }
}
    
}
