package 11-july-2024;

public class reverseSubstringsBetweenEachPairofParentheses {


    Name Of The Problem :- 1190. Reverse Substrings Between Each Pair of Parentheses

    Date :- 11-July-2024


    You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.

*****************************************************************************************************************************************************


class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openBracket = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket.push(result.length());
            } else if (ch == ')') {
                int start = openBracket.pop();
                reverse(result, start, result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
        
    }
}
    
}
