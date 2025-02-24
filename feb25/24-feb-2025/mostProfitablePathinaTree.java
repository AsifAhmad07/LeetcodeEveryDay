package 24-feb-2025;

public class mostProfitablePathinaTree {


    Name Of The Problem :- 2467. Most Profitable Path in a Tree

    Date :- 24-February-2025

    There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] represents:

the price needed to open the gate at node i, if amount[i] is negative, or,
the cash reward obtained on opening the gate at node i, otherwise.
The game goes on as follows:

Initially, Alice is at node 0 and Bob is at node bob.
At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, while Bob moves towards node 0.
For every node along their path, Alice and Bob either spend money to open the gate at that node, or accept the reward. Note that:
If the gate is already open, no price will be required, nor will there be any cash reward.
If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly, if the reward at the gate is c, both of them receive c / 2 each.
If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. Note that these events are independent of each other.
Return the maximum net income Alice can have if she travels towards the optimal leaf node.

 

Example 1:


Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
Output: 6
Explanation: 
The above diagram represents the given tree. The game goes as follows:
- Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
  Alice's net income is now -2.
- Both Alice and Bob move to node 1. 
  Since they reach here simultaneously, they open the gate together and share the reward.
  Alice's net income becomes -2 + (4 / 2) = 0.
- Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
  Bob moves on to node 0, and stops moving.
- Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
Now, neither Alice nor Bob can make any further moves, and the game ends.
It is not possible for Alice to get a higher net income.
Example 2:


Input: edges = [[0,1]], bob = 1, amount = [-7280,2350]
Output: -7280
Explanation: 
Alice follows the path 0->1 whereas Bob follows the path 1->0.
Thus, Alice opens the gate at node 0 only. Hence, her net income is -7280. 
 

Constraints:

2 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.
1 <= bob < n
amount.length == n
amount[i] is an even integer in the range [-104, 104].



*****************************************************************************************************************************************************

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Map<Integer, Integer> bobMap = new HashMap<>();
    int aliceIncome;

    boolean DFSBob(int curr, int t, boolean[] visited) {
        visited[curr] = true;
        bobMap.put(curr, t);

        if (curr == 0) { // reached target
            return true;
        }

        for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[ngbr]) {
                if (DFSBob(ngbr, t + 1, visited)) {
                    return true;
                }
            }
        }

        bobMap.remove(curr);
        return false;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length; // n nodes (0 to n-1)
        aliceIncome = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // DFS on Bob for finding time to reach each node till 0
        int time = 0;
        boolean[] visited = new boolean[n];
        DFSBob(bob, time, visited);

        int income = 0;
        Arrays.fill(visited, false);

        // BFS se karunga
        Queue<int[]> que = new LinkedList<>();
        // {node, time, income}
        que.add(new int[]{0, 0, 0});

        while (!que.isEmpty()) {
            int[] front = que.poll();
            int curr = front[0];
            int t = front[1];
            int inc = front[2];

            if (!bobMap.containsKey(curr) || bobMap.get(curr) > t) {
                inc += amount[curr];
            } else if (t == bobMap.get(curr)) {
                inc += (amount[curr] / 2);
            }

            if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
                aliceIncome = Math.max(aliceIncome, inc);
            }

            for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    que.add(new int[]{ngbr, t + 1, inc});
                }
            }

            visited[curr] = true;
        }

        return aliceIncome;
    }
}
    
}
