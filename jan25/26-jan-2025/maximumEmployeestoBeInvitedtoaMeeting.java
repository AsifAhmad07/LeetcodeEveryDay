package 26-jan-2025;

public class maximumEmployeestoBeInvitedtoaMeeting {


    Name Of The Problem :- 2127. Maximum Employees to Be Invited to a Meeting

    Date :- 26-January-2025

    A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

 

Example 1:


Input: favorite = [2,2,1,2]
Output: 3
Explanation:
The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
The maximum number of employees that can be invited to the meeting is 3. 
Example 2:

Input: favorite = [1,2,0]
Output: 3
Explanation: 
Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
The seating arrangement will be the same as that in the figure given in example 1:
- Employee 0 will sit between employees 2 and 1.
- Employee 1 will sit between employees 0 and 2.
- Employee 2 will sit between employees 1 and 0.
The maximum number of employees that can be invited to the meeting is 3.
Example 3:


Input: favorite = [3,0,1,4,1]
Output: 4
Explanation:
The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
So the company leaves them out of the meeting.
The maximum number of employees that can be invited to the meeting is 4.
 

Constraints:

n == favorite.length
2 <= n <= 105
0 <= favorite[i] <= n - 1
favorite[i] != i


*****************************************************************************************************************************************************

class Solution {
    public int BFS(int start, Map<Integer, List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // {node, path length}
        queue.add(new int[]{start, 0});
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currNode = current[0];
            int dist = current[1];

            for (int neighbor : adj.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                    maxDistance = Math.max(maxDistance, dist + 1);
                }
            }
        }

        return maxDistance;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build reversed graph
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = favorite[i];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int longestCycleEmplCount = 0;
        int happyCoupleEmplCount = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> mp = new HashMap<>();
                int currNode = i;
                int currNodeCount = 0;

                while (!visited[currNode]) { // Until cycle is not detected
                    visited[currNode] = true;
                    mp.put(currNode, currNodeCount);

                    int nextNode = favorite[currNode]; // Favorite node of currNode
                    currNodeCount++;

                    if (mp.containsKey(nextNode)) { // Cycle detected
                        int cycleLength = currNodeCount - mp.get(nextNode);
                        longestCycleEmplCount = Math.max(longestCycleEmplCount, cycleLength);

                        if (cycleLength == 2) { // Happy couple case
                            boolean[] visitedNodes = new boolean[n];
                            visitedNodes[currNode] = true;
                            visitedNodes[nextNode] = true;
                            happyCoupleEmplCount += 2 + BFS(currNode, adj, visitedNodes) + BFS(nextNode, adj, visitedNodes);
                        }
                        break;
                    }
                    currNode = nextNode;
                }
            }
        }

        return Math.max(happyCoupleEmplCount, longestCycleEmplCount);
    }
}
    
}
