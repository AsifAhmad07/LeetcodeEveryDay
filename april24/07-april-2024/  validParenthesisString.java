package 07-april-2024;

public class validParenthesisString {


    Name Of The Problem :-   678. Valid Parenthesis String


    Date :- 07-April-2024

    Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> asterisksSt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openSt.push(i);
            } else if (ch == '*') {
                asterisksSt.push(i);
            } else {
                if (!openSt.isEmpty()) {
                    openSt.pop();
                } else if (!asterisksSt.isEmpty()) {
                    asterisksSt.pop();
                } else {
                    return false;
                }
            }
        }

        // This post processing will be required for cases like - "*(())(*"
        while (!openSt.isEmpty() && !asterisksSt.isEmpty()) {
            if (openSt.peek() > asterisksSt.peek()) {
                return false;
            }
            openSt.pop();
            asterisksSt.pop();
        }

        return openSt.isEmpty();
        
    }
}
  
  
    
}
