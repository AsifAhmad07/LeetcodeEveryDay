package 12-march-2024;

public class removeZeroSumConsicutiveNodesFromLinkedList {



    Name Of The Proble :- 1171. Remove Zero Sum Consecutive Nodes from Linked List

    Date :- 12-march-2024


    Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 

Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.


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
    public ListNode removeZeroSumSublists(ListNode head) {
          int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);
        
        while (head != null) {
            prefixSum += head.val;
            
            if (map.containsKey(prefixSum)) {
                ListNode p = map.get(prefixSum);
                ListNode start = p;
                int pSum = prefixSum;
                
                while (start != head) {
                    start = start.next;
                    pSum += start.val;
                    if (start != head) {
                        map.remove(pSum);
                    }
                }
                
                p.next = start.next;
                
            } else {
                map.put(prefixSum, head);
            }
            
            head = head.next;
        }
        
        return dummy.next;
        
    }
}


    
}
