package 21-may-2024;

public class subsets {


    Name Of The Problem :- 78. Subsets

    Date :- 21-May-2024

    Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

    *************************************************************************************************************************************************

    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
             List<Integer> temp = new ArrayList<>();
            solve(nums, 0, temp);
            return result;
            
        }
        private void solve(int[] nums, int idx, List<Integer> temp) {
            if (idx >= nums.length) {
                result.add(new ArrayList<>(temp));
                return;
            }
    
            temp.add(nums[idx]);
            solve(nums, idx + 1, temp);
            temp.remove(temp.size() - 1);
            solve(nums, idx + 1, temp);
        }
    }
    
}
