package 17-dec-2024;

public class constructStringWithRepeatLimit {


    Name Of The Problem :- 2182. Construct String With Repeat Limit

    Date :- 17-December-2024


    You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.

 

Example 1:

Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
Example 2:

Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa". 
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
 

Constraints:

1 <= repeatLimit <= s.length <= 105
s consists of lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

           int[] count = new int[26]; 
        for (char ch : s.toCharArray()) { 
            count[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int i = 25;

        while (i >= 0) { 
            if (count[i] == 0) {
                i--;
                continue;
            }

            char ch = (char) ('a' + i); 
            int freq = Math.min(count[i], repeatLimit); 
            
            for (int k = 0; k < freq; k++) {
                result.append(ch);
            }
            count[i] -= freq;

            if (count[i] > 0) {
                int j = i - 1;
                while (j >= 0 && count[j] == 0) { 
                    j--;
                }

                if (j < 0) {
                    break; 
                }

                result.append((char) ('a' + j)); 
                count[j]--;
            }
        }

        return result.toString();
        
    }
}
    
}
