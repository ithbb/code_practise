/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode t1 = head;
        ListNode t2 = head;
        while(t2.next!=null &&t2.next.next != null) {
    
            t1 = t1.next;
            t2 = t2.next.next;
            if (t1 == t2) {
                return true;
            }
            
        }
        return false;
    }
}
