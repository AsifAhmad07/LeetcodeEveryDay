package 05-jan-2024;

public class longetIncreasingSubsequence {
    /*
     * Name Of The Problem :- 300. Longest Increasing Subsequence
     * Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
             int n = nums.length;
    
            int[] t = new int[n];
            Arrays.fill(t,1);
        
            int maxLIS = 1;
            
            for(int i = 1; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]) {
                        t[i] = Math.max(t[i], t[j] + 1);
                        maxLIS = Math.max(maxLIS, t[i]);
                    }
                }
            }
    
            return maxLIS;
            // here is my final solution for day 05 jan
            
        }
    }
    
}
