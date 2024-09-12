package 12-sept-2024;

public class counttheNumberofConsistentStrings {



    Name Of The Problem  :- 1684. Count the Number of Consistent Strings

    Date :- 12-September-2024

    You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 

Constraints:

1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0;

        // Iterate over each word in words
        for (String word : words) {
            boolean allCharAllowed = true;

            // Check if every character in the word is in the allowedSet
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    allCharAllowed = false;
                    break;
                }
            }

            // Increment count if all characters are allowed
            if (allCharAllowed) {
                count++;
            }
        }

        return count;
        
    }
}

    
}
