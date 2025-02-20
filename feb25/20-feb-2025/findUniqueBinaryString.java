package 20-feb-2025;

public class findUniqueBinaryString {


    Name Of The Problem :- 1980. Find Unique Binary String

    Date :- 20-February-2025

    Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.


*****************************************************************************************************************************************************

class Solution {
    public String findDifferentBinaryString(String[] nums) {

         HashSet<Integer> set = new HashSet<>();
        
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        
        String result = "";
        
        for (int number = 0; number <= 65536; number++) {
            if (!set.contains(number)) {
                result = Integer.toBinaryString(number);
                while (result.length() < n) { 
                    result = "0" + result;
                }

                return result;
            }
        }
        
        return "";
        
    }
}
    
}
