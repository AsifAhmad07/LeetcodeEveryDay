package 23-april-2024;

public class minimumHeightTrees {


    Name Of The Problem :- 310. Minimum Height Trees



    Date :- 23-April-2024

    A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.

*****************************************************************************************************************************************************

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

         if (n == 1)
            return Collections.singletonList(0);
        
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1)
                que.offer(i);
        }
        
        while (n > 2) {
            int size = que.size();
            n -= size; 
            
            while (size-- > 0) {
                int u = que.poll();
                for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                    indegree[v]--;
                    if (indegree[v] == 1)
                        que.offer(v);
                }
            }
        }
        
        while (!que.isEmpty()) {
            result.add(que.poll());
        }
        return result;
        
    }
}
    
}
