package 30-march-2024;

public class subarrayswitKDifferentIntegers {


    Name Of The Problem :- 992. Subarrays with K Different Integers


    Date :- 30-march-2024


    Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
        
    }
    public int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        int n = nums.length;
        int i = 0; 
        int j = 0;
        
        int count = 0;
        
        while(j < n) {
            
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            while(mp.size() > k) {
                // Shrink the window
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            
            count += (j - i + 1); // Ending at j
            j++;
        }
        
        return count;
    }
}
    
}
