package 04-june-2024;

public class longestPalindrome {


    Name Of The Problem :- 409. Longest Palindrome

    Date :- 04-june-2024

    Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.


*****************************************************************************************************************************************************


class Solution {
    public int longestPalindrome(String s) {
         int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        int result = 0;
        int oddFreq = 0;
        
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(map.get(ch) % 2 != 0) {
                oddFreq++;
            } else {
                oddFreq--;
            }
        }
        
        if(oddFreq > 0) {
            return n - oddFreq + 1;
        }
        
        return n;
        
    }
}
    
}
