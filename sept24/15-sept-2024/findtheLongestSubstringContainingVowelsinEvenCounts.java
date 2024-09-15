package 15-sept-2024;

public class findtheLongestSubstringContainingVowelsinEvenCounts {



    Name Of The Problem :- 1371. Find the Longest Substring Containing Vowels in Even Counts

    Date :- 15-September-2024

    Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

 

Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
Example 2:

Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
Example 3:

Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 

Constraints:

1 <= s.length <= 5 x 10^5
s contains only lowercase English letters

*****************************************************************************************************************************************************
class Solution {
    public int findTheLongestSubstring(String s) {

        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 2);
        vowels.put('i', 4);
        vowels.put('o', 8);
        vowels.put('u', 16);
        
        // Map to store the first occurrence of each bitmask
        // Start with bitmask 0 at index -1, for cases where the entire string is valid
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, -1);
        
        int mask = 0; // Current bitmask
        int maxLength = 0; // Result variable to store the maximum length
        
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is a vowel, update the bitmask
            if (vowels.containsKey(c)) {
                mask ^= vowels.get(c);
            }
            
            // If the bitmask has been seen before, calculate the length of the substring
            if (firstOccurrence.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - firstOccurrence.get(mask));
            } else {
                // If this is the first time we've seen this bitmask, store the index
                firstOccurrence.put(mask, i);
            }
        }
        
        return maxLength;
    }
}
        
    

    
}
