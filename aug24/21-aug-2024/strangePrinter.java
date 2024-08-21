package 21-aug-2024;

public class strangePrinter {



    Name Of The Problem :- 664. Strange Printer

    Date :- 21-August-2024

    There is a strange printer with the following two special properties:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.

 

Example 1:

Input: s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:

Input: s = "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 

Constraints:

1 <= s.length <= 100
s consists of lowercase English letters.



*****************************************************************************************************************************************************
class Solution {
    private int n;
    private int[][] t;

    private int solve(int l, int r, String s) {
        if (l == r)
            return 1;
        else if (l > r)
            return 0;

        if (t[l][r] != -1)
            return t[l][r];

        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l))
            i++;

        if (i == r + 1)
            return 1;

        int normal = 1 + solve(i, r, s);

        int aageKa = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(l) == s.charAt(j)) {
                int x = solve(i, j - 1, s) + solve(j, r, s);
                aageKa = Math.min(aageKa, x);
            }
        }

        return t[l][r] = Math.min(aageKa, normal);
    }

    public int strangePrinter(String s) {
        n = s.length();
        t = new int[n][n + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(0, n - 1, s);
    }
}
    
}
