package 13-march-2025;

public class zeroArrayTransformationII {

    Name Of The Problem :- 3356. Zero Array Transformation II

    Date :- 13-March-2025

    You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

 

Example 1:

Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]

Output: 2

Explanation:

For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
Example 2:

Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]

Output: -1

Explanation:

For i = 0 (l = 1, r = 3, val = 2):
Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
The array will become [4, 1, 0, 0].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
The array will become [3, 0, 0, 0], which is not a Zero Array.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 5 * 105
1 <= queries.length <= 105
queries[i].length == 3
0 <= li <= ri < nums.length
1 <= vali <= 5

*****************************************************************************************************************************************************
class Solution {
    private int n, Q;

    private boolean checkWithDifferenceArray(int[] nums, int[][] queries, int k) {
        int[] diff = new int[n + 1];

        // Apply first k queries using a difference array
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            diff[l] += x;
            if (r + 1 < n) {
                diff[r + 1] -= x;
            }
        }

        // Apply difference array effect on nums
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            if (nums[i] - cumSum > 0) { // If any element remains positive, return false
                return false;
            }
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;
        Q = queries.length;

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0; // Already all zeros
        }

        int left = 1, right = Q, answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkWithDifferenceArray(nums, queries, mid)) {
                answer = mid;
                right = mid - 1; // Try for a smaller `k`
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
    
}
