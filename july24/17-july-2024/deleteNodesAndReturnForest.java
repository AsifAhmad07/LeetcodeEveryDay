package 17-july-2024;

public class deleteNodesAndReturnForest {


    Name Of The Problem :- 1110. Delete Nodes And Return Forest

    Date :- 17-July-2024

    Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.


*****************************************************************************************************************************************************a

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
    private TreeNode deleteHelper(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
       if (root == null) {
           return null;
       }

       root.left = deleteHelper(root.left, toDelete, result);
       root.right = deleteHelper(root.right, toDelete, result);

       if (toDelete.contains(root.val)) {
           if (root.left != null) {
               result.add(root.left);
           }
           if (root.right != null) {
               result.add(root.right);
           }
           return null;
       } else {
           return root;
       }
   }

   public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
       Set<Integer> toDelete = new HashSet<>();

       for (int num : to_delete) {
           toDelete.add(num);
       }

       deleteHelper(root, toDelete, result);

       if (!toDelete.contains(root.val)) {
           result.add(root);
       }

       return result;
       
   }
}
    
}
