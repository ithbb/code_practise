/*
Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4, you should return the list as 2->1->4->3.

Challenge
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode after = head.next;
        
        // Payattention to the after  == null case:
        // 5-> null
        
        while(head != null && after != null) {
          pre.next = after;
          head.next = after.next;
          after.next = head;
         
          pre = pre.next.next;
          if (pre.next == null || pre.next.next == null) {
              break;
          } else {
              head = pre.next;
              after = pre.next.next;
          }
        }
        return dummy.next;
        
    }
}
