package 05-june-2024;

public class findCommonCharacters {

    Name Of The Problem :- 1002. Find Common Characters

    Date :- 05-June-2024

    Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.


*****************************************************************************************************************************************************English


class Solution {
    public void fillCountArray(String word, int[] count) {
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
    }

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int n = words.length;
        int[] count = new int[26];
        fillCountArray(words[0], count);
        for (int i = 1; i < n; i++) {
            int[] temp = new int[26];
            fillCountArray(words[i], temp);

            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        return result;
    }
}
    
}
