package 13-oct-2024;

public class smallestRangeCoveringElementsfromKLists {


    Name Of The Problem :- 632. Smallest Range Covering Elements from K Lists

    Date :- 13-October-2024

    You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Example 2:

Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
 

Constraints:

nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-105 <= nums[i][j] <= 105
nums[i] is sorted in non-decreasing order.


*****************************************************************************************************************************************************


class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
         int k = nums.size();
        int[] vec = new int[k];
        int[] resultRange = { -1000000, 1000000 };
        
        while (true) {
            int minEl = Integer.MAX_VALUE;
            int maxEl = Integer.MIN_VALUE;
            int minElListIdx = 0;
            for (int i = 0; i < k; i++) {
                int listIdx = i;
                int elIdx = vec[i];
                int element = nums.get(listIdx).get(elIdx);
                
                if (element < minEl) {
                    minEl = element;
                    minElListIdx = listIdx;
                }
                
                maxEl = Math.max(maxEl, element);
            }
            if (maxEl - minEl < resultRange[1] - resultRange[0]) {
                resultRange[0] = minEl;
                resultRange[1] = maxEl;
            }
            int nextIndex = vec[minElListIdx] + 1;
            if (nextIndex >= nums.get(minElListIdx).size()) {
                break;  
            }
            vec[minElListIdx] = nextIndex;
        }

        return resultRange;
        
    }
}
}
