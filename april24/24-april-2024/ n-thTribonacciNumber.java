package 24-april-2024;

public class  n-thTribonacciNumber {


    Name Of The Problem :- 1137. N-th Tribonacci Number


    Date :- 24-April-2024


    The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.


*****************************************************************************************************************************************************Of



class Solution {
    int[] t = new int[38];
    
    public int find(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (t[n] != -1) return t[n];
        
        int a = find(n - 1);
        int b = find(n - 2);
        int c = find(n - 3);
        
        return t[n] = a + b + c;
    }
    public int tribonacci(int n) {
        Arrays.fill(t, -1);
        return find(n);
        
    }
}
    
}
