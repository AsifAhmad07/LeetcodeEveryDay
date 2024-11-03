package 03-nov-2024;

public class rotateString {



    Name Of The Problem :- 796. Rotate String

    Date :- 03-Novemebr-2024

    Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    public boolean rotateString(String s, String goal) {
         int m = s.length();
        int n = goal.length();
        if (m == n && (s + s).contains(goal)) {
            return true;
        }
        
        return false;
        
    }
}
    
}
