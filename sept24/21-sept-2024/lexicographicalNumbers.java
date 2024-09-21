package 21-sept-2024;

public class lexicographicalNumbers {


    Name Of The Problem :- 386. Lexicographical Numbers

    Date :- 21-September-2024

    Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104


*****************************************************************************************************************************************************
class Solution {
    private void solve(int curr, int n, List<Integer> result) {
       if (curr > n) {
           return;
       }
       
       result.add(curr);  
       
       for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
           int nextNum = curr * 10 + nextDigit;
           
           if (nextNum > n) {
               return;
           }
           
           solve(nextNum, n, result);  
       }
   }
   public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
       for (int num = 1; num <= 9; num++) {
           solve(num, n, result);
       }
       
       return result; 
       
   }
}
    
}
