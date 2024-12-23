package 23-dec-2024;

public class minimumNumberofOperationstoSortaBinaryTreebyLevel {

    Name Of The Problem :- 2471. Minimum Number of Operations to Sort a Binary Tree by Level

    Date :- 23-December-2024

    You are given the root of a binary tree with unique values.

In one operation, you can choose any two nodes at the same level and swap their values.

Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.

The level of a node is the number of edges along the path between it and the root node.

 

Example 1:


Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
Example 2:


Input: root = [1,3,2,7,6,5,4]
Output: 3
Explanation:
- Swap 3 and 2. The 2nd level becomes [2,3].
- Swap 7 and 4. The 3rd level becomes [4,6,5,7].
- Swap 6 and 5. The 3rd level becomes [4,5,6,7].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
Example 3:


Input: root = [1,2,3,4,5,6]
Output: 0
Explanation: Each level is already sorted in increasing order so return 0.
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 105
All the values of the tree are unique.

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
    public int countMinSwapsToSort(List<Integer> vec) {
        int swaps = 0;
        List<Integer> sortedVec = new ArrayList<>(vec);
        Collections.sort(sortedVec);

        Map<Integer, Integer> mp = new HashMap<>(); // nums[i] -> i
        for (int i = 0; i < vec.size(); i++) {
            mp.put(vec.get(i), i);
        }

        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals(sortedVec.get(i))) {
                continue; // no swap required
            }

            int currIdx = mp.get(sortedVec.get(i));
            mp.put(vec.get(i), currIdx);
            mp.put(vec.get(currIdx), i);
            Collections.swap(vec, currIdx, i);
            swaps++;
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int result = 0;

        while (!que.isEmpty()) {
            int n = que.size(); // total nodes in the current level
            List<Integer> vec = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                vec.add(temp.val);

                if (temp.left != null) {
                    que.add(temp.left);
                }

                if (temp.right != null) {
                    que.add(temp.right);
                }
            }

            result += countMinSwapsToSort(vec);
        }

        return result;
    }
}
    
}
