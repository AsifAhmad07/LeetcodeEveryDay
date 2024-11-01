package 01-nov-2024;

public class deleteCharacterstoMakeFancyString {

    Name Of THe Problem :- 1957. Delete Characters to Make Fancy String

    Date :- 01-Novemebr-2024

    A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

 

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.

*****************************************************************************************************************************************************

class Solution {
    public String makeFancyString(String s) {

        StringBuilder sb = new StringBuilder();
        int freq = 0;
        char curr = '/';
        for(char ch : s.toCharArray()){
            if(ch != curr){
                freq = 1;
                curr = ch;
                sb.append(ch);
            }else if(freq < 2){
                freq++;
                sb.append(ch);
            }else{
                continue;
            }
        }
        return sb.toString();
        
    }
}
}