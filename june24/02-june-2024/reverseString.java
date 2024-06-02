package 02-june-2024;

public class reverseString {

    Name Of The Problem :- 344. Reverse String

    Date :- 02-June-2024


    Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


*****************************************************************************************************************************************************a

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;

        int i = 0, j = n - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        
    }
}
    
}
