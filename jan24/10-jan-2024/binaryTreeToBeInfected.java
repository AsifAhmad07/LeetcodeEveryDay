package 10-jan-2024;

public class binaryTreeToBeInfected {
    /*
     * Name Of The Problem :- 2385. Amount of Time for Binary Tree to Be Infected
     * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

 

Example 1:


Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
Example 2:


Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 105
Each node has a unique value.
A node with a value of start exists in the tree.

     */
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void convert(TreeNode current, int parent, Map<Integer, List<Integer>> adj) {
       if (current == null) {
           return;
       }

       if (parent != -1) {
           adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(parent);
       }

       if (current.left != null) {
           adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.left.val);
       }
       if (current.right != null) {
           adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.right.val);
       }
       convert(current.left, current.val, adj);
       convert(current.right, current.val, adj);
   }
   public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
       convert(root, -1, adj);

       Queue<Integer> que = new LinkedList<>();
       que.add(start);
       Set<Integer> visited = new HashSet<>();
       visited.add(start);
       int minutes = 0;

       while (!que.isEmpty()) {
           int n = que.size();

           while (n-- > 0) {
               int curr = que.poll();

               for (int ngbr : adj.getOrDefault(curr, Collections.emptyList())) {
                   if (!visited.contains(ngbr)) {
                       que.add(ngbr);
                       visited.add(ngbr);
                   }
               }
           }
           minutes++;
       }

       return minutes - 1;
       
   }
}
    
}
