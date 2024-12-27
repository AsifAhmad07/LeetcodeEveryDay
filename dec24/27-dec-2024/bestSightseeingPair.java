package 27-dec-2024;

public class bestSightseeingPair {

    Name Of The Problem :- 1014. Best Sightseeing Pair

    Date :- 27-December-2024

    You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2
 

Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000


*****************************************************************************************************************************************************

class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;

        int result = 0;

        int maxTillNow = values[0] + 0; 

        for (int j = 1; j < n; j++) {
            int x = values[j] - j;
            int y = maxTillNow;

            result = Math.max(result, x + y);

            maxTillNow = Math.max(maxTillNow, values[j] + j);
        }

        return result;
        
    }
}
    
}
