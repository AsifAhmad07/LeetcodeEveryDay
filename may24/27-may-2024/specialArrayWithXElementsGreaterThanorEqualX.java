import java.util.jar.Attributes.Name;

package 27-may-2024;

public class specialArrayWithXElementsGreaterThanorEqualX {

    Name Of The Problem :- 1608. Special Array With X Elements Greater Than or Equal X

    Date :- 27-May-2024

    You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

 

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
Example 2:

Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.
Example 3:

Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000

*****************************************************************************************************************************************************
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int l = 0, r = n;
        while (l <= r) {
            int mid_x = l + (r - l) / 2;
            int i = lowerBound(nums, mid_x);

            if (n - i == mid_x) {
                return mid_x;
            } else if (n - i > mid_x) {
                l = mid_x + 1;
            } else {
                r = mid_x - 1;
            }
        }

        return -1;
        
    }
     private int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

    
}
