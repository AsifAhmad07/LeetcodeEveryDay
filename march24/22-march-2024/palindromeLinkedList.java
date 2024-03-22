package 22-march-2024;

public class palindromeLinkedList {


    Name Of The Problem :- 234. Palindrome Linked List

    Date :- 22-march-2024

    Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?


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
    ListNode curr;

    public boolean solve(ListNode head) {
        if(head == null)
            return true;

        if(!solve(head.next) || head.val != curr.val) {
            return false;
        }

        curr = curr.next;
        return true;
    }
    public boolean isPalindrome(ListNode head) {
         curr = head;

        return solve(head);
        
    }
}
    
}
