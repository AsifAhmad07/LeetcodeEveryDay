package 19-aug-2024;

public class 2KeysKeyboard {


    Name Of The Problem :- 650. 2 Keys Keyboard


    Date :- 19-August-2024

    There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Initially, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:

Input: n = 1
Output: 0
 

Constraints:

1 <= n <= 1000

*****************************************************************************************************************************************************

class Solution {
    int[][] t = new int[1001][1001];
    
    private int solve(int currCountA, int pasteCountA, int n) {
        if (currCountA == n) {
            return 0;
        }

        if (currCountA > n) {
            return 1000;
        }

        if (t[currCountA][pasteCountA] != -1) {
            return t[currCountA][pasteCountA];
        }

        int copyPaste = 1 + 1 + solve(currCountA + currCountA, currCountA, n);

        int paste = 1 + solve(currCountA + pasteCountA, pasteCountA, n);

        return t[currCountA][pasteCountA] = Math.min(copyPaste, paste);
    }

    public int minSteps(int n) {
        if (n == 1)
            return 0; // We already have 1 A
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        // We have to start with a copy, hence 1 + 
        return 1 + solve(1, 1, n);
    }
}

    
}
