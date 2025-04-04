package 16-oct-2024;

public class longestHappyString {


    Name Of The Problem :- 1405. Longest Happy String

    Date :- 16-October-2024

    A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.
 

Constraints:

0 <= a, b, c <= 100
a + b + c > 0


*****************************************************************************************************************************************************

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]); // max-heap

        if (a > 0) {
            pq.offer(new int[]{a, 'a'});
        }
        if (b > 0) {
            pq.offer(new int[]{b, 'b'});
        }
        if (c > 0) {
            pq.offer(new int[]{c, 'c'});
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCount = curr[0];
            char currChar = (char) curr[1];

            // Check if the last two characters are the same as the current character
            if (result.length() >= 2 && result.charAt(result.length() - 1) == currChar 
                    && result.charAt(result.length() - 2) == currChar) {
                
                if (pq.isEmpty()) {
                    break; // No valid character to use
                }

                // Use the next most frequent character
                int[] next = pq.poll();
                int nextCount = next[0];
                char nextChar = (char) next[1];
                result.append(nextChar);
                nextCount--;
                
                if (nextCount > 0) {
                    pq.offer(new int[]{nextCount, nextChar});
                }
                
                // Push the current character back into the queue
                pq.offer(curr);
            } else {
                // Use the current character
                result.append(currChar);
                currCount--;

                if (currCount > 0) {
                    pq.offer(new int[]{currCount, currChar});
                }
            }
        }

        return result.toString();
    }
}
    
}
