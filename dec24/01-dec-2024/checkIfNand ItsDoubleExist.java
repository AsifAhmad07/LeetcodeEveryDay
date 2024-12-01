package 01-dec-2024;

public class checkIfNand ItsDoubleExist {

    

    Name Of The Problem :- 1346. Check If N and Its Double Exist

    Date :- 01-December-2024

    Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103


*****************************************************************************************************************************************************

class Solution {
    public boolean checkIfExist(int[] arr) {
          int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i] * 2)) {
                return true;
            } 
            else if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
        
    }
}
}