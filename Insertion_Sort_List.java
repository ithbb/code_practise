Skip to content
 This repository
Explore
Gist
Blog
Help
ithbb ithbb
 
1  Unwatch 
  Star 0
 Fork 0ithbb/leetcode
 branch: master  leetcode / Insertion_Sort_List
ithbbithbb 3 minutes ago Create Insertion_Sort_List
1 contributor
54 lines (46 sloc)  1.38 kb RawBlameHistory   
/**
 * Sort a linked list using insertion sort.  
 * Definition for singly-linked list.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = head;
        while(node!= null && node.next != null) {
            if (node.next.val < node.val) {
                //moveToPosition(node.next);
                int val = node.next.val;
                ListNode l = pre;
                while(l.next != node.next) {
                    if(l.next.val > val) {
                        //Move to here
                        ListNode tmp = node.next;
                        node.next = tmp.next;
                        
                        tmp.next = l.next;
                        
                        l.next = tmp;
                     
                        break;   
                    }
                    l = l.next;
                }
            } else {
             
              node = node.next;
            }
        }
        return pre.next;
        
    }
    

}

