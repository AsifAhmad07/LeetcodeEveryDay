package 09-feb-2024;

public class largestDivisibleSubset {

    Name Of The Problem :- 368. Largest Divisible Subset

    Date :- 09-feb-2024


    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.


-----------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         Arrays.sort(nums);

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIndex = 0;
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (t[i] > maxL) {
                        maxL = t[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }

        return result;
        
    }
}
    
}
