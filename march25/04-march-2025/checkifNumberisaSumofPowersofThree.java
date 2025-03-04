package 04-march-2025;

public class checkifNumberisaSumofPowersofThree {

    Name Of The Problem :- 1780. Check if Number is a Sum of Powers of Three

    Date :- 04-March-2025

    Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.

 

Example 1:

Input: n = 12
Output: true
Explanation: 12 = 31 + 32
Example 2:

Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 34
Example 3:

Input: n = 21
Output: false
 

Constraints:

1 <= n <= 107


*****************************************************************************************************************************************************

class Solution {
    public boolean checkPowersOfThree(int n) {

         int p = 0;

        while (Math.pow(3, p) <= n) {
            p++;
        }

        while (n > 0) {
            if (n >= Math.pow(3, p)) {
                n -= Math.pow(3, p);
            }

            if (n >= Math.pow(3, p)) {
                return false;
            }

            p--;
        }

        return true;
        
    }
}
    
}
