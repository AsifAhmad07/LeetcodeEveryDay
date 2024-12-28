import java.util.Base64.Decoder;

package 28-dec-2024;

public class maximumSumof3Non-OverlappingSubarrays {


    Name Of The Problem :- 689. Maximum Sum of 3 Non-Overlapping Subarrays

    Date :- 28-December-2024


    Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

 

Example 1:

Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Example 2:

Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] < 216
1 <= k <= floor(nums.length / 3)


*****************************************************************************************************************************************************

class Solution {
    private int[][] dp = new int[20001][4];

    private int helper(int[] sums, int k, int idx, int rem) {
        if (rem == 0) return 0;
        if (idx >= sums.length) return Integer.MIN_VALUE;

        if (dp[idx][rem] != -1) {
            return dp[idx][rem];
        }

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        dp[idx][rem] = Math.max(take, notTake);
        return dp[idx][rem];
    }

    private void solve(int[] sums, int k, int idx, int rem, List<Integer> indices) {
        if (rem == 0 || idx >= sums.length) return;

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        if (take >= notTake) {
            indices.add(idx);
            solve(sums, k, idx + k, rem - 1, indices);
        } else {
            solve(sums, k, idx + 1, rem, indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize the memoization array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = nums.length - k + 1;
        int[] sums = new int[n];
        int windowSum = 0;
        int i = 0, j = 0;

        // Calculate window sums
        while (j < nums.length) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                sums[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        List<Integer> indices = new ArrayList<>();
        solve(sums, k, 0, 3, indices);

        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}
    
}
