/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/


public class LRUCache {
    
    private Node head;
    private int cap;
    private int size;
    
    HashMap<Integer, Node> hashMap;
    
    public LRUCache(int capacity) {
        head = null;
        cap = capacity;
        size = 0;
        hashMap = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
         
        if(hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            
            node.pre = null;
            node.next = head;
            head = node;
            return node.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        
        boolean exist = hashMap.containsKey(key);
        if (exist) {
            Node tmpNode = hashMap.get(key);
            tmpNode.value = value;
            
            
            tmpNode.pre.next = tmpNode.next;
            tmpNode.next.pre = tmpNode.pre;
            
            tmpNode.pre = null;
            tmpNode.next = head;
            head = tmpNode;            
            
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            
            if(head != null) {
                newNode.next = head;
                head.pre = newNode;
                head = newNode;
            } else {
                head = newNode;
            }
            hashMap.put(key, newNode);
            if (size < cap) {
              size++;
            } else {
              Node lastNode = head;
              while(lastNode != null && lastNode.next!= null & lastNode.next.next != null) {
                  lastNode = lastNode.next;
              }

              hashMap.remove(lastNode.next.key);
              lastNode.next = null;
              
            }
        }
    }
    
    
    
    class Node {
        public int value;
        public int key;
        public Node next;
        public Node pre;
    }
}
