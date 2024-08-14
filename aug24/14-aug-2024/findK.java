package 14-aug-2024;

public class findK-thSmallestPairDistance {


    Name Of The Problem :- 719. Find K-th Smallest Pair Distance

    Date :- 14-August-2024

    The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

 

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5
 

Constraints:

n == nums.length
2 <= n <= 104
0 <= nums[i] <= 106
1 <= k <= n * (n - 1) / 2


*****************************************************************************************************************************************************

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
           int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt();
        int[] vec = new int[maxEl + 1];

        // All pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                vec[d]++;
            }
        }

        for (int d = 0; d <= maxEl; d++) {
            k -= vec[d];
            if (k <= 0) {
                return d; // Returning kth smallest distance
            }
        }
        return -1;
        
    }
}



    
}
