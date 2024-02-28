package 28-feb-2024;

public class findBottomLeftTreeValue {


    Name Of The Problem :- 513. Find Bottom Left Tree Value


    Date :- 28-feb-2024

    Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


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
    private int maxDepth;
    private int bottomLeft;
    
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        
        solve(root, 0);
        return bottomLeft;
    }
    
    private void solve(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            bottomLeft = root.val;
        }
        
        solve(root.left, currDepth + 1);
        solve(root.right, currDepth + 1);
    }
}

    
}
