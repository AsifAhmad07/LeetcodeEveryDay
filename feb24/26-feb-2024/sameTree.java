package 26-feb-2024;

public class sameTree {


    Name Of The Problem :- 100. Same Tree


    Date :- 26-feb-2024


    Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode first = q1.poll();
            TreeNode second = q2.poll();

            if (first.val != second.val) {
                return false;
            }

            if (first.left != null && second.left != null) {
                q1.add(first.left);
                q2.add(second.left);
            } else if (first.left != null || second.left != null) {
                return false;
            }

            if (first.right != null && second.right != null) {
                q1.add(first.right);
                q2.add(second.right);
            } else if (first.right != null || second.right != null) {
                return false;
            }
        }

        return true;
        
    }
}
    
}
