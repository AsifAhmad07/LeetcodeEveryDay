package 26-june-2024;

public class balanceaBinarySearchTree {

    Name Of The Problem :- 1382. Balance a Binary Search Tree

    Date :- 26-June-2024

    Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105
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
    private void inOrder(TreeNode root, List<Integer> vec) {
        if (root == null) {
            return;
        }
        inOrder(root.left, vec);
        vec.add(root.val);
        inOrder(root.right, vec);
    }

    private TreeNode construct(int l, int r, List<Integer> vec) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(vec.get(mid));
        root.left = construct(l, mid - 1, vec);
        root.right = construct(mid + 1, r, vec);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vec = new ArrayList<>();
        inOrder(root, vec);
        return construct(0, vec.size() - 1, vec);
    }
}



    
}
