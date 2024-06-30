package 30-june-2024;

public class removeMaxNumberofEdgestoKeepGraphFullyTraversable {

    Name Of The Problem :- 1579. Remove Max Number of Edges to Keep Graph Fully Traversable


    Date :- 30-June-2024

    Alice and Bob have an undirected graph of n nodes and three types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 

Example 1:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
Example 2:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
Output: 0
Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
Example 3:



Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
Output: -1
Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.
 

 

Constraints:

1 <= n <= 105
1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)
edges[i].length == 3
1 <= typei <= 3
1 <= ui < vi <= n
All tuples (typei, ui, vi) are distinct.


*****************************************************************************************************************************************************


class Solution {
    class DSU {
    private int[] parent;
    private int[] rank;
    private int components;

    public DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        components = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) 
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) 
            return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        components--;
    }

    public boolean isSingle() {
        return components == 1;
    }
}
    public int maxNumEdgesToRemove(int n, int[][] edges) {

         Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);

        int addedEdge = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {
                boolean add = false;

                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    add = true;
                }

                if (Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    add = true;
                }

                if (add)
                    addedEdge++;

            } else if (type == 2) {
                if (Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    addedEdge++;
                }
            } else {
                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    addedEdge++;
                }
            }
        }

        if (Alice.isSingle() && Bob.isSingle()) {
            return edges.length - addedEdge;
        }

        return -1;
        
    }
}
    
}
