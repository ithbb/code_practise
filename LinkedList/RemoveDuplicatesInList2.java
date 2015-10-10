/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode start = head;
        head = head.next;
        
        while (head != null) {
            
            
            if (start.val != head.val) {
                pre = pre.next;
                
            } else {
            
                while (head != null && start.val == head.val ) {
                    head = head.next;
                }
                
                //deleteRange between pre and head
                start = pre.next;
                while(start != head) {
                    ListNode tmp = start.next;
                    start.next = null;
                    start = tmp;
                }
                
                pre.next = head;
            }
            
            // Goto next round
            if(head != null) {
                start = head;
                head = head.next;
            
            }
            
        }
        return dummy.next;
        
    }
    
}

