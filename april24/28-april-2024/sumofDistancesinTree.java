package 28-april-2024;

public class sumofDistancesinTree {


    Name Of The Problem :- 834. Sum of Distances in Tree

    Date :- 28-April-2024


    There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.

*****************************************************************************************************************************************************

public class Solution {
    // Store count of subtrees of each node
    long resultBaseNode = 0;
    int[] count;
    int N;

    public int dfsBase(HashMap<Integer, ArrayList<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;

        resultBaseNode += currDepth;

        ArrayList<Integer> children = adj.getOrDefault(currNode, new ArrayList<>());
        for (int child : children) {
            if (child == prevNode)
                continue;

            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }

        // Store count of subtrees of each node
        count[currNode] = totalNode;

        return totalNode;
    }

    public void DFS(HashMap<Integer, ArrayList<Integer>> adj, int parentNode, int prevNode, int[] result) {

        ArrayList<Integer> children = adj.getOrDefault(parentNode, new ArrayList<>());
        for (int child : children) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            DFS(adj, child, parentNode, result);
        }

    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];
        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        resultBaseNode = 0;

        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];

        result[0] = (int) resultBaseNode;

        DFS(adj, 0, -1, result);

        return result;
    }
}
    
}
