package 25-july-2024;

public class sortanArray {


    Name Of The Problem :- 912. Sort an Array

    Date :- 25-July-2024

    Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104


*****************************************************************************************************************************************************are

class Solution {
    public int[] sortArray(int[] nums) {
         int minE = Arrays.stream(nums).min().getAsInt();
        int maxE = Arrays.stream(nums).max().getAsInt();

        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        int i = 0;
        
        for (int num = minE; num <= maxE; num++) {
            while (mp.getOrDefault(num, 0) > 0) {
                nums[i] = num;
                i++;
                mp.put(num, mp.get(num) - 1);
            }
        }
        
        return nums;
        
    }
}
    
}
