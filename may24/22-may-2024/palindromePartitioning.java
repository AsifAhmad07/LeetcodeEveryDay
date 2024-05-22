package 22-may-2024;

public class palindromePartitioning {


    Name Of The Problem :- 131. Palindrome Partitioning

    Date :- 22-May-2024

    Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.


*****************************************************************************************************************************************************


class Solution {
    private int n;
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
        if (idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        backtrack(s, 0, curr, result);
        
        return result;
    }
}
    
}
