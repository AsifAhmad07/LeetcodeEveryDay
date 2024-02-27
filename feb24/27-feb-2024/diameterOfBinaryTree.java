package 27-feb-2024;

public class diameterOfBinaryTree {


    Name Of The Problem :- 543. Diameter of Binary Tree

    Date :- 27-feb-2024


    Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100


-----------------------------------------------------------------------------------------------------------------------------------------------------



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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int[] result = { Integer.MIN_VALUE };
        diameter(root, result);

        return result[0];
    }

    private int diameter(TreeNode root, int[] result) {
        if (root == null)
            return 0;

        int left = diameter(root.left, result);
        int right = diameter(root.right, result);

        result[0] = Math.max(result[0], left + right);

        return Math.max(left, right) + 1;
        
    }
}

    
}
