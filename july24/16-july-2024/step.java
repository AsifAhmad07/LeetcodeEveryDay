package 16-july-2024;

public class step-By-StepDirectionsFromaBinaryTreeNodetoAnother {


    Name Of The Problem :- 2096. Step-By-Step Directions From a Binary Tree Node to Another

    Date :- 16-July-2024

    You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue

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

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        // Explore left
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        // Explore right
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDst = new StringBuilder();

        findPath(root, startValue, rootToSrc); // O(n)
        findPath(root, destValue, rootToDst);  // O(n)

        int l = 0; // commonPathLength
        while (l < rootToSrc.length() && l < rootToDst.length() && rootToSrc.charAt(l) == rootToDst.charAt(l)) {
            l++;
        }

        StringBuilder result = new StringBuilder();
        // Add "U"
        for (int i = 0; i < rootToSrc.length() - l; i++) {
            result.append('U');
        }

        for (int i = l; i < rootToDst.length(); i++) {
            result.append(rootToDst.charAt(i));
        }

        return result.toString();
    }
}
    
}
