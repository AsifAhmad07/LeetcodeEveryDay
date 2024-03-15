package 15-march-2024;

public class productOfArrayExceptSelf {


    Name Of The Problem :- 238. Product of Array Except Self


    Date :- 15-march-2024


    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


-----------------------------------------------------------------------------------------------------------------------------------------------------



class Solution {
    public int[] productExceptSelf(int[] nums) {

        int N = nums.length;
        int []pm = new int[N];
        int []sm = new int[N];
        int []ans = new int[N];
        pm[0] = 1;
        sm[N-1] = 1;
        for(int i = 1; i < N; i++){
            pm[i] = pm[i-1] * nums[i-1];
        }
        for(int i = N - 2; i >= 0; i-- ){
            sm[i] = sm[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < N; i++){
            ans[i] = pm[i] * sm[i];
        }
        return ans;
        
    }
}
    
}
