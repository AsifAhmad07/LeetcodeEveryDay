package 27-nov-2024;

public class shortestDistanceAfterRoadAdditionQueriesI {


    Name Of The Problem :- 3243. Shortest Distance After Road Addition Queries I


    Date :- 27-Novemebr-2024


    You are given an integer n and a 2D integer array queries.

There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.

queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.

Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.

 

Example 1:

Input: n = 5, queries = [[2,4],[0,2],[0,4]]

Output: [3,2,1]

Explanation:



After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.



After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.



After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

Example 2:

Input: n = 4, queries = [[0,3],[0,2]]

Output: [1,1]

Explanation:-



After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.



After the addition of the road from 0 to 2, the length of the shortest path remains 1.

 

Constraints:

3 <= n <= 500
1 <= queries.length <= 500
queries[i].length == 2
0 <= queries[i][0] < queries[i][1] < n
1 < queries[i][1] - queries[i][0]
There are no repeated roads among the queries.



*****************************************************************************************************************************************************

class Solution {
    private Map<Integer, List<int[]>> adj = new HashMap<>();

    private int dijkstra(int n) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); 

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            if (node == n - 1) {
                return result[n - 1];
            }

            if (d > result[node]) {
                continue;
            }

            if (!adj.containsKey(node)) {
                continue;
            }

            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0];
                int dist = edge[1];
                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[]{d + dist, adjNode});
                }
            }
        }

        return result[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        for (int i = 0; i < n - 1; ++i) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{i + 1, 1});
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, 1});
            result[i] = dijkstra(n);
        }

        return result;
    }
}

}
