package 18-july-2024;

public class numberofGoodLeafNodesPairs {


    Name Of The Problem :- 1530. Number of Good Leaf Nodes Pairs

    Date :- 18-July-2024

    You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.

 

Example 1:


Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
Example 2:


Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
Example 3:

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].
 

Constraints:

The number of nodes in the tree is in the range [1, 210].
1 <= Node.val <= 100
1 <= distance <= 10


*****************************************************************************************************************************************************

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
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
       if (root == null) {
           return;
       }

       if (root.left == null && root.right == null) { // Leaf node
           leafNodes.add(root);
       }

       if (prev != null) {
           adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
           adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
       }

       makeGraph(root.left, root, adj, leafNodes);
       makeGraph(root.right, root, adj, leafNodes);
   }
   public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>(); // Graph
       Set<TreeNode> leafNodes = new HashSet<>(); // Leaf nodes

       makeGraph(root, null, adj, leafNodes);

       int count = 0; // Count of good node pairs

       for (TreeNode leaf : leafNodes) {
           // Perform BFS and see if you can find other leaf nodes within distance
           Queue<TreeNode> queue = new LinkedList<>();
           Set<TreeNode> visited = new HashSet<>();
           queue.add(leaf);
           visited.add(leaf);

           for (int level = 0; level <= distance; level++) { // Only go till level <= distance
               int size = queue.size();
               while (size-- > 0) { // Process level
                   TreeNode curr = queue.poll();

                   if (curr != leaf && leafNodes.contains(curr)) {
                       count++;
                   }

                   for (TreeNode neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                       if (!visited.contains(neighbor)) {
                           queue.add(neighbor);
                           visited.add(neighbor);
                       }
                   }
               }
           }
       }
       return count / 2;
       
   }
}
    
}
