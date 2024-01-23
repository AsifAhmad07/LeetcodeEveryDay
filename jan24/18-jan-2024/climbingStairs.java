package 18-jan-2024;

public class climbingStairs {
    /*
     * Name Of The Problem :- 70. Climbing Stairs
     * Date :- 18-jan-2024
     * 
     * 
     * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
     */

     class Solution {
        public int climbStairs(int n) {
            if(n == 1 || n == 2 || n == 3)
                return n;
            
            int a = 1;
            int b = 2;
            int c = 3;
            
            for(int i = 3; i<=n; i++) {
                c = a + b;
                
                int temp_b = b;
                b = c;
                a = temp_b;
                
            }
            return c;
            
        }
    }
    
}
