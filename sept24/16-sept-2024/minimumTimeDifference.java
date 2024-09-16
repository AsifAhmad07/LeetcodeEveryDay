package 16-sept-2024;

public class minimumTimeDifference {

    Name Of The Problem :- 539. Minimum Time Difference

    Date :- 16-September-2024

    Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".


*****************************************************************************************************************************************************

class Solution {
    public int findMinDifference(List<String> timePoints) {

        int n = timePoints.size();
        int[] minutes = new int[n];

        // Convert timePoints to minutes
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            String[] parts = time.split(":");

            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            minutes[i] = hours * 60 + mins;
        }
        Arrays.sort(minutes);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }

        result = Math.min(result, (24 * 60 - minutes[n - 1]) + minutes[0]);

        return result;
        
    }
}
    
}
