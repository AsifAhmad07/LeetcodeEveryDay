package 07-aug-2024;

public class integertoEnglishWords {


    Name Of The Problem :- 273. Integer to English Words

    Date :- 07-August-2024

    Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

Constraints:

0 <= num <= 231 - 1

*****************************************************************************************************************************************************

class Solution {
    private static final Map<Integer, String> belowTen = Map.of(
        0, "", 1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "Five", 
        6, "Six", 7, "Seven", 8, "Eight", 9, "Nine"
    );

    private static final Map<Integer, String> belowTwenty = Map.of(
        10, "Ten", 11, "Eleven", 12, "Twelve", 13, "Thirteen", 14, "Fourteen", 
        15, "Fifteen", 16, "Sixteen", 17, "Seventeen", 18, "Eighteen", 19, "Nineteen"
    );

    private static final Map<Integer, String> belowHundred = Map.of(
        2, "Twenty", 3, "Thirty", 4, "Forty", 5, "Fifty", 
        6, "Sixty", 7, "Seventy", 8, "Eighty", 9, "Ninety"
    );

    public String solve(int num) {
        if (num < 10) {
            return belowTen.get(num);
        }

        if (num < 20) {
            return belowTwenty.get(num);
        }

        if (num < 100) { // 89 = "Eighty Nine"
            return belowHundred.get(num / 10) + (num % 10 != 0 ? " " + belowTen.get(num % 10) : "");
        }

        if (num < 1000) { // 879 / 100 = 8 "Eight"
            return solve(num / 100) + " Hundred" + (num % 100 != 0 ? " " + solve(num % 100) : "");
        }

        if (num < 1000000) {
            return solve(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + solve(num % 1000) : "");
        }

        if (num < 1000000000) {
            return solve(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + solve(num % 1000000) : "");
        }

        return solve(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + solve(num % 1000000000) : "");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return solve(num);
    }
}
    
}
