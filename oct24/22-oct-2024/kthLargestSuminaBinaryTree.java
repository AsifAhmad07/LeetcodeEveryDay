package 22-oct-2024;

public class kthLargestSuminaBinaryTree {


    Name Of The Problem :- 2583. Kth Largest Sum in a Binary Tree

    Date :- 22-October-2024

    You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.

 

Example 1:


Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
Explanation: The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2nd largest level sum is 13.
Example 2:


Input: root = [1,2,null,3], k = 1
Output: 3
Explanation: The largest level sum is 3.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= 106
1 <= k <= n


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
    public long kthLargestLevelSum(TreeNode root, int k) {
         Deque<TreeNode> levelQ = new ArrayDeque<>();
         PriorityQueue<Long> minSumQ = new PriorityQueue<>();
         levelQ.offer(root);
         while(!levelQ.isEmpty()){
            long currLvlSum = 0l;
            int lvlSize = levelQ.size();
            while(lvlSize-->0){
                TreeNode currNode = levelQ.poll();
                if(currNode.left != null){
                    levelQ.offer(currNode.left);
                }
                if(currNode.right != null){
                    levelQ.offer(currNode.right);
                }
                currLvlSum += currNode.val;
            }
            minSumQ.offer(currLvlSum);
            if(minSumQ.size() > k)minSumQ.poll();
         }
         return (minSumQ.size() == k) ? minSumQ.peek() : -1;
        
    }
}
    
}
