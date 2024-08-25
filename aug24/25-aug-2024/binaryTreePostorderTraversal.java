package 25-aug-2024;

public class binaryTreePostorderTraversal {



    Name Of THe Problem :- 145. Binary Tree Postorder Traversal

    Date :- 25-August-2024

    Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

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
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
        fun(root,result);
        return result;

    }

    private void fun(TreeNode root, List<Integer> result){
        if(root != null){
            fun(root.left,result);
            fun(root.right,result);
            result.add(root.val);
        }
        
    }
}
    
}
