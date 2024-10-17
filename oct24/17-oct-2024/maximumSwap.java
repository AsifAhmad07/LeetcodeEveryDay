package 17-oct-2024;

public class maximumSwap {


    Name Of The Problem :- 670. Maximum Swap

    Date :- 17-October-2024

    You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

 

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
 

Constraints:

0 <= num <= 108


*****************************************************************************************************************************************************

class Solution {
    public int maximumSwap(int num) {
         String s = Integer.toString(num); 
        int n = s.length();
        int[] maxRight = new int[n];
        maxRight[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = maxRight[i + 1];
            char rightMaxElement = s.charAt(rightMaxIdx);
            if (s.charAt(i) > rightMaxElement) {
                maxRight[i] = i;
            } else {
                maxRight[i] = rightMaxIdx;
            }
        }

      
        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            char maxRightElement = s.charAt(maxRightIdx);
            if (s.charAt(i) < maxRightElement) {
                char[] charArray = s.toCharArray();
                char temp = charArray[i];
                charArray[i] = charArray[maxRightIdx];
                charArray[maxRightIdx] = temp;
                return Integer.parseInt(new String(charArray));
            }
        }

        return num;
        
    }
}
    
}
