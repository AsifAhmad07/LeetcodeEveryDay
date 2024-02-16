package 16-feb-2024;

public class leastNumberOfUniqueIntegersAfterKRemovals {



    Name Of The Problem :- 1481. Least Number of Unique Integers after K Removals

    Date :- 16-feb-2024


    Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(mp.values());
        int elementsRemoved = 0;
        while (!pq.isEmpty()) {
    
            elementsRemoved += pq.peek();
            if (elementsRemoved > k) {
                return pq.size();
            }
            pq.poll();
        }
        return 0;
        
    }
}
    
}
