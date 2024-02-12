package 12-feb-2024;

public class majorityElement {


    Name Of The Problem :- 169. Majority Element

    Date :- 12-feb-2024

    Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

---------------------------------------------------------------------------------------------------

class Solution {
    public int majorityElement(int[] nums) {

          int n = nums.length;
        int count = 0;
        Integer maj = null;

        for (int i = 0; i < n; i++) {
            if (maj != null && nums[i] == maj) {
                count++;
            } else if (count == 0) {
                maj = nums[i];
                count = 1;
            } else {
                count--;
            }
        }

        return maj;
        
    }
}
    
}
