package jan24.27-jan-2024;

public class kInversePair {

    Name Of The Problem :- 629. K Inverse Pairs Array

    Date :- 27-jan-2024

    For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].

Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.

 

Example 1:

Input: n = 3, k = 0
Output: 1
Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.
Example 2:

Input: n = 3, k = 1
Output: 2
Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 

Constraints:

1 <= n <= 1000
0 <= k <= 1000


----------------------------------------------------------------------------------------


class Solution {
    int M = 1000000007;
   public int kInversePairs(int n, int k) {
         int[][] t = new int[n + 1][k + 1];

       // t[i][j] = total number of arrays having (1 to i) and exactly j inversions

       // for j = 0, t[i][0] = 1
       for (int i = 0; i <= n; i++) {
           t[i][0] = 1;
       }

       // O(n*k)
       for (int i = 1; i <= n; i++) {
           long cumSum = 1;
           for (int j = 1; j <= k; j++) {

               cumSum += t[i - 1][j];
               if (j >= i) {
                   cumSum -= t[i - 1][j - i];
               }
               t[i][j] = (int) (cumSum % M);
           }
       }

       return t[n][k];
       
   }
}
    
}
