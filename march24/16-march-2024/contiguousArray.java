package 16-march-2024;

public class contiguousArray {


    Name Of The Problem :- 525. Contiguous Array


    Date :- 16-march-2024


    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.


-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    public int findMaxLength(int[] nums) {

         int n = nums.length;
        if (n == 1)
            return 0;
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int currSum = 0;
        int maxL = 0;
        
        mp.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            currSum += (nums[i] == 1) ? 1 : -1;
            if (mp.containsKey(currSum)) {
                maxL = Math.max(maxL, i - mp.get(currSum));
            } else
                mp.put(currSum, i);
        }
        return maxL;
        
    }
}
    
}
