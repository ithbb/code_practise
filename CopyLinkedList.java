/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> nodeMap = new HashMap<>();
        Node cur = new Node();
        cur.next = head;
        
        int i = 0;
        while (cur.next != null) {
            cur = cur.next;
            nodeMap.put(cur, i++); 
        }
        
        
        Node newHead = new Node();
        Node newCur = newHead;
        cur = new Node();
        cur.next = head;
        Map<Integer, Node> locMap = new HashMap<>();
        int j = 0;
        while(cur.next != null) {
            cur = cur.next;
            newCur = newCur.next;
            
            newCur.val = cur.val;
            newCur.next = new Node();
            locMap.put(j, newCur);
        }
        
        
        cur = new Node();
        cur.next = head;
        newCur = new Node();
        newCur.next = newHead;
        while(cur.next != null) {
            cur = cur.next;
            newCur = newCur.next;
            
            Integer locRandom = nodeMap.get(cur.random);
            Node newRandom = locMap.get(locRandom);
            newCur.random = newRandom;
        }
        return newHead.next;
    }
}
