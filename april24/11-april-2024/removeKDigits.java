package 11-april-2024;

public class removeKDigits {


    Name Of The Problem :- 402. Remove K Digits

    Date :- 11-April-2024

    Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public String removeKdigits(String num, int k) {
         StringBuilder result = new StringBuilder(); // it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            while(result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            
            if(result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); // to avoid the case when we have preceding zeros
            }
        }
        
        while(result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        if(result.length() == 0) {
            return "0";
        }
        
        return result.toString();
        
    }
}
    
}
