public class LRUCache {
    
    private Node head;
    private int cap;
    private int size;
    public LRUCache(int capacity) {
        head = new Node();
        head.next = null;
        cap = capacity;
        size = 0;
    }
    
    public int get(int key) {
        Node t = head;
        while(t != null) {
            if (t.key == key) {
                return t.value;
            }
            t = t.next;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        Node p = head;
        while (p.next != null && p.next.key != key) {
            p = p.next;
        }
        if(p.next != null && p.next.key == key) {
            p.next.value = value;
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.next = null;
            p.next = newNode;
            if (size < cap) {
              size++;
              
            } else {
              Node tmp = head;
              head = head.next;
              tmp.next = null;
            }
        }
    }
    
    
    class Node {
        public int value;
        public int key;
        public Node next;
    }
}
