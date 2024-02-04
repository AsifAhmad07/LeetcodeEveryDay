package 04-feb-2024;

public class minsubstringsubwindow {


    Name Of The Problem :- 76. Minimum Window Substring

    Date :- 04-feb-2024



    Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?


------------------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    public String minWindow(String s, String t) {
        

         int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = t.length();
        int i = 0, j = 0;
        int minStart = 0;
        int minWindow = Integer.MAX_VALUE;

        while (j < n) {
            char ch_j = s.charAt(j);
            if (mp.containsKey(ch_j) && mp.get(ch_j) > 0)
                requiredCount--;

            mp.put(ch_j, mp.getOrDefault(ch_j, 0) - 1);

            while (requiredCount == 0) { // try to shrink the window
                if (minWindow > j - i + 1) {
                    minWindow = j - i + 1;
                    minStart = i;
                }

                char ch_i = s.charAt(i);
                mp.put(ch_i, mp.getOrDefault(ch_i, 0) + 1);
                if (mp.containsKey(ch_i) && mp.get(ch_i) > 0)
                    requiredCount++;
                i++;
            }

            j++; // Don't ever forget this :-)
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindow);
    }
}
    
}
