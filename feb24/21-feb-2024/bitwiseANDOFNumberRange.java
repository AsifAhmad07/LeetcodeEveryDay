package 21-feb-2024;

public class bitwiseANDOFNumberRange {


    Name Of The Problem :- 201. Bitwise AND of Numbers Range


    Date :- 21-feb-2024


    Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0
 

Constraints:

0 <= left <= right <= 231 - 1


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
         int shiftCount = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        return left << shiftCount;
        
    }
}
    
}
