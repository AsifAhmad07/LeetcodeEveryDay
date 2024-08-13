package 13-aug-2024;

public class combinationSumII {


    Name Of The Problem :- 40. Combination Sum II

    Date :- 13-August-2024

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30


*****************************************************************************************************************************************************

class Solution {
    public void solve(int[] candidates, int target, List<Integer> curr, List<List<Integer>> result, int idx) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue; // Ignore duplicate elements
            }
            curr.add(candidates[i]);
            solve(candidates, target - candidates[i], curr, result, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        solve(candidates, target, curr, result, 0);
        return result;
    }
}
    
}
