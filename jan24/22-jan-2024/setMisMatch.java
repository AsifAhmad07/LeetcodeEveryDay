import java.util.HashMap;
import java.util.Map;

package 22-jan-2024;

public class setMisMatch {

    /*
     * Name Of The Problem :- 645. Set Mismatch
     * Date :- Date :- 22-jan-2024
     * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
     */

     public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int miss = 0, dup = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                miss = i;
            }
        }
        
        return new int[]{dup, miss};
        
    }
}
    
}
