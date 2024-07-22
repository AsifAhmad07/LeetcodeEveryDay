package 22-july-2024;

public class sortthePeople {


    Name Of The Problem :- 2418. Sort the People

    Date :- 22-July-2024

    You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

 

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.

*****************************************************************************************************************************************************

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Create a map to store heights and corresponding names
        Map<Integer, String> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(heights[i], names[i]);
        }

        // Convert heights array to a list and sort it in descending order
        List<Integer> heightsList = new ArrayList<>();
        for (int height : heights) {
            heightsList.add(height);
        }
        heightsList.sort(Collections.reverseOrder());

        // Update names array according to sorted heights
        for (int i = 0; i < n; i++) {
            names[i] = mp.get(heightsList.get(i));
        }

        return names;
        
    }
}
    
}
