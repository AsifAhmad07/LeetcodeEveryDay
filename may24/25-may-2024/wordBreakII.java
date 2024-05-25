package 25-may-2024;

public class wordBreakII {


    Name Of The Problem :- 140. Word Break II

    Date :- 25-May-2024
    Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesndoesn't exceed 105



***************************************************************************************************************************************************** 


class Solution {
    private List<String> result;
   private Set<String> dict;

   private void solve(int i, String currSentence, String s) {
       if (i >= s.length()) {
           result.add(currSentence.trim());
           return;
       }

       for (int j = i; j < s.length(); j++) {
           String tempWord = s.substring(i, j + 1);

           if (dict.contains(tempWord)) {
               String originalSentence = currSentence;
               if (!currSentence.isEmpty()) {
                   currSentence += " ";
               }
               currSentence += tempWord;

               solve(j + 1, currSentence, s);

               currSentence = originalSentence;
           }
       }
   }

   public List<String> wordBreak(String s, List<String> wordDict) {
       result = new ArrayList<>();
       dict = new HashSet<>(wordDict);

       String currSentence = "";
       solve(0, currSentence, s);

       return result;
       
   }
}
    
    
}
