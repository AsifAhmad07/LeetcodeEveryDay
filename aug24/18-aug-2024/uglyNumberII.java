package 18-aug-2024;

public class uglyNumberII {


    Name Of THe Problem :- 264. Ugly Number II

    Date :- 18-August-2024

    An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690



*****************************************************************************************************************************************************


class Solution {
    public int nthUglyNumber(int n) {
         int[] t = new int[n + 1];
        // t[i] = ith Ugly number;
        // we will return t[n] = nth ugly number

        t[1] = 1; // 1st Ugly number

        int i2 = 1; // i2th Ugly number
        int i3 = 1; // i3rd Ugly number
        int i5 = 1; // i5th Ugly number

        for (int i = 2; i <= n; i++) {
            int i2th_ugly = t[i2] * 2;
            int i3rd_ugly = t[i3] * 3;
            int i5th_ugly = t[i5] * 5;

            t[i] = Math.min(Math.min(i2th_ugly, i3rd_ugly), i5th_ugly);

            if (t[i] == i2th_ugly) {
                i2++;
            }

            if (t[i] == i3rd_ugly) {
                i3++;
            }

            if (t[i] == i5th_ugly) {
                i5++;
            }
        }

        return t[n];
        
    }
}
    
}
