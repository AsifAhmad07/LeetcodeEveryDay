package 27-feb-2025;

public class lengthofLongestFibonacciSubsequence {

    Name Of The Problem :- 873. Length of Longest Fibonacci Subsequence

    Date :- 27-February-2025

    A sequence x1, x2, ..., xn is Fibonacci-like if:

n >= 3
xi + xi+1 == xi+2 for all i + 2 <= n
Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.

A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

 

Example 1:

Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: arr = [1,3,7,11,12,14,18]
Output: 3
Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
 

Constraints:

3 <= arr.length <= 1000
1 <= arr[i] < arr[i + 1] <= 109


*****************************************************************************************************************************************************

class Solution {
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int[][] t = new int[n][n];
        for (int[] row : t) Arrays.fill(row, 2);

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }
        
        int max_length = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int target = arr[k] - arr[j];
                if (mp.containsKey(target) && mp.get(target) < j) {
                    int i = mp.get(target);
                    t[j][k] = t[i][j] + 1;
                }
                max_length = Math.max(max_length, t[j][k]);
            }
        }
        return max_length >= 3 ? max_length : 0;
        
    }
}
    
}
