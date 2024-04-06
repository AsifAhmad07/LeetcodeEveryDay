package 06-april-2024;

public class minimumRemovetoMakeValidParentheses {


    Name Of The Problem :- 1249. Minimum Remove to Make Valid Parentheses


    Date :- 06-April-2024

    Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public String minRemoveToMakeValid(String s) {
         int open = 0;
        StringBuilder temp = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c == '(') 
                open++;
            else if(c == ')') {
                if(open == 0)
                    continue;
                open--;
            }
            
            temp.append(c);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = temp.length() - 1; i >= 0; i--) {
            if(temp.charAt(i) == '(' && open-- > 0)
                continue;
            result.insert(0, temp.charAt(i));
        }
        
        return result.toString();
        
    }
}
    
}
