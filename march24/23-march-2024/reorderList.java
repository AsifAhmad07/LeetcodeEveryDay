package 23-march-2024;

public class reorderList {



    Name Of The Problem :- 143. Reorder List


    Date :- 23-march-2024

    You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000


-----------------------------------------------------------------------------------------------------------------------------------------------------


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
         Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int k = stack.size() / 2;
        curr = head;
        while (k-- > 0) {
            ListNode topNode = stack.pop();

            ListNode temp = curr.next;
            curr.next = topNode;
            topNode.next = temp;
            curr = temp;
        }

        if (curr != null)
            curr.next = null;
    }
}       
    
}
