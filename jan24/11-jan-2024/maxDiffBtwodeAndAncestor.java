import javax.swing.tree.TreeNode;

package 11-jan-2024;

public class maxDiffBtwodeAndAncestor {
    /*
     * Name Of The Problem :- 1026. Maximum Difference Between Node and Ancestor
     * Date :- 11-jan-2024
     * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

 

Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:


Input: root = [1,null,2,null,0,3]
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105
     * 
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
    public int findMaxDiff(TreeNode root, int minV, int maxV) {
       if (root == null) {
           return Math.abs(minV - maxV);
       }

       minV = Math.min(root.val, minV);
       maxV = Math.max(root.val, maxV);

       int l = findMaxDiff(root.left, minV, maxV);
       int r = findMaxDiff(root.right, minV, maxV);

       return Math.max(l, r);
   }

   public int maxAncestorDiff(TreeNode root) {
        int minV = root.val;
       int maxV = root.val;

       return findMaxDiff(root, minV, maxV);
       
   }
}
    
}
