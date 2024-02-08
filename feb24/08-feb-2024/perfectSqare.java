import java.util.jar.Attributes.Name;

package 08-feb-2024;

public class perfectSqare {


    Name Of The Problem :- 279. Perfect Squares

    Date :- 08-feb-2024

    Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104

---------------------------------------------------------------------------------------------------


class Solution {
    public int numSquares(int n) {
        int[] t = new int[n + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        // t[i] = min number of perfect squares to get i
        t[0] = 0;

        for (int i = 1; i <= n; i++) {

            // For each i, it must be the sum of some number (i - j*j) and 
            // a perfect square number (j*j).
            for (int j = 1; j * j <= i; j++) {
                int remain = i - j * j;

                t[i] = Math.min(t[i], 1 + t[remain]);
            }
        }

        return t[n];
        
    }
}



}
