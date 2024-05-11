package 11-may-2024;

public class minimumcosttoHireKWorkers {


    Name Of The Problem :- 857. Minimum Cost to Hire K Workers


    Date :- 11-May-2024

    There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group must be paid at least their minimum wage expectation.
In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
 

Constraints:

n == quality.length == wage.length
1 <= k <= n <= 104
1 <= quality[i], wage[i] <= 104

*****************************************************************************************************************************************************

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] min_wage, int k) {
         int n = quality.length;
        double[][] worker_ratio = new double[n][2];
        for (int worker = 0; worker < n; worker++) {
            worker_ratio[worker][0] = (double) min_wage[worker] / quality[worker];
            worker_ratio[worker][1] = quality[worker];
        }
        Arrays.sort(worker_ratio, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum_quality = 0;
        for (int i = 0; i < k; i++) {
            pq.offer((int) worker_ratio[i][1]); 
            sum_quality += worker_ratio[i][1]; 
        }

        double managerRatio = worker_ratio[k - 1][0];
        double result = managerRatio * sum_quality;

        for (int manager = k; manager < n; manager++) {
            managerRatio = worker_ratio[manager][0];

            pq.offer((int) worker_ratio[manager][1]); 
            sum_quality += worker_ratio[manager][1];

            if (pq.size() > k) {
                sum_quality -= pq.poll();
            }

            result = Math.min(result, managerRatio * sum_quality);
        }

        return result;
        
    }
}
    
}
