package 06-feb-2024;

public class groupanagrams {


    Name Of The Problem :- 49. Group Anagrams

    Date :- 06-feb-2024

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

--------------------------------------------------------------------------------------------------


class Solution {
    public String generate(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder new_s = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                new_s.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
            }
        }

        return new_s.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            String new_s = generate(s);

            mp.computeIfAbsent(new_s, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : mp.values()) {
            result.add(new ArrayList<>(group));
        }

        return result;
        
    }
}
    
}
