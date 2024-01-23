import java.util.HashSet;
import java.util.Set;

package 12-jan-2024;

public class stringHalvesAreAlike {
    /*
     * Name Of The Problem :- 1704. Determine if String Halves Are Alike
     * Date :- 12-jan-2024
     * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

 

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
 

Constraints:

2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.
     */
    class Solution {
        public boolean halvesAreAlike(String s) {
             int n = s.length();
    
            int mid = n / 2;
    
            int i = 0, j = mid;
    
            int countL = 0;
            int countR = 0;
    
            Set<Character> vowels = new HashSet<>();
            String vowelString = "aeiouAEIOU";
            for (char c : vowelString.toCharArray()) {
                vowels.add(c);
            }
    
            while (i < n / 2 && j < n) {
                if (vowels.contains(s.charAt(i))) countL++;
    
                if (vowels.contains(s.charAt(j))) countR++;
    
                i++;
                j++;
            }
    
            return countL == countR;
            
        }
    }
    
}
