package 10-feb-2025;

public class clearDigits {


    Name Of The Problem :- 3174. Clear Digits
    Date :- 10-February-2025

    You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.



*****************************************************************************************************************************************************
class Solution {
    public String clearDigits(String s) {

        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i < sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
        
    }
}
    
}
