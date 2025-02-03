package 03-feb-2025;

public class longestStrictlyIncreasingorStrictlyDecreasingSubarray {


    Name Of The Problem :- 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
    Date :- 03-February-2025

    You are given an array of integers nums. Return the length of the longest 
subarray
 of nums which is either 
strictly increasing
 or 
strictly decreasing
.

 

Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.

 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 50


*****************************************************************************************************************************************************

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
          int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int increasing = 1;
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) {
                increasing++;
                j++;
            }

            int decreasing = 1;
            j = i + 1;
            while (j < n && nums[j] < nums[j - 1]) {
                decreasing++;
                j++;
            }

            result = Math.max(result, Math.max(increasing, decreasing));
        }

        return result;
        
    }
}
    
}
