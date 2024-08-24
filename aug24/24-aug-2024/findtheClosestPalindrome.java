package 24-aug-2024;

public class findtheClosestPalindrome {



    Name Of The Problem :- 564. Find the Closest Palindrome

    Date :- 24-August-2024

    Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].


*****************************************************************************************************************************************************
class Solution {
    public long findNearestPallindrome(long firstHalf, boolean isOdd){
       long res = firstHalf; //12 21 -> 1221, 12 2 21 -> 12221
       if(isOdd){
           firstHalf/=10;
       }
       while(firstHalf>0){
           res = res *10 + (firstHalf%10);
           firstHalf/=10;
       }
       return res;
   }
   public String nearestPalindromic(String n) {
       ArrayList<Long> list = new ArrayList<Long>();
       int len = n.length();
       boolean isOdd = (len%2!=0);
       //copy first half
       int mid = (len%2==0)?(len/2):(len/2+1);
       Long firstHalf = Long.parseLong(n.substring(0,mid));
       list.add(findNearestPallindrome(firstHalf,isOdd));
       list.add(findNearestPallindrome(firstHalf+1,isOdd));
       list.add(findNearestPallindrome(firstHalf-1,isOdd));
       list.add((long)Math.pow(10,len-1)-1); //all 9's
       list.add((long)Math.pow(10,len)+1); //101,1001,10001...
       long num = Long.parseLong(n);
       long minDiff = Long.MAX_VALUE;
       long res = Long.MAX_VALUE;
       for(Long element : list){
           if(element == num) continue;
           long curDiff = Math.abs(element - num);
           if(curDiff < minDiff){
               res = element;
               minDiff = curDiff;
           }else if(curDiff == minDiff){
               res = Math.min(res,element);
           }
       }
       return String.valueOf(res);
       
   }
}
    
}
