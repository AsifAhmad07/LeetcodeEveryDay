package 23-aug-2024;

public class fractionAdditionandSubtraction {


    Name Of The Problem :- 592. Fraction Addition and Subtraction

    Date :- 23-August-2024

    Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
Example 2:

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
Example 3:

Input: expression = "1/3-1/2"
Output: "-1/6"
 

Constraints:

The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1, 10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.


*****************************************************************************************************************************************************
class Solution {
    public String fractionAddition(String expr) {
        int nume = 0; 
        int deno = 1;

        int i = 0;
        int n = expr.length();
        while (i < n) {
            int currNume = 0; 
            int currDeno = 0; 

            boolean isNeg = (expr.charAt(i) == '-');
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                i++;
            }
            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currNume = (currNume * 10) + val;
                i++;
            }

            i++; 

            if (isNeg) {
                currNume *= -1; 
            }
            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }
            nume = nume * currDeno + currNume * deno;
            deno = deno * currDeno;
        }
        int gcd = gcd(Math.abs(nume), deno);

        nume /= gcd;
        deno /= gcd;
        return nume + "/" + deno;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
        
    }
}
    
}
