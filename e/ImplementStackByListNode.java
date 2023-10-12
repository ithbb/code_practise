public class StackUsingLL {

public class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
    }
}

Node head;

boolean isEmpty() {
    if(head==null)return true;
    return false;
}

void push(int x) {
    Node newNode= new Node(x);
    if(head==null) {
        head=newNode;
    }
    newNode.next=head;
    head=newNode;
    
}

int pop() {
    if(head==null) {
        System.out.println("Stack is empty");
        return 0;
    }else {
        int popped=head.data;
        head= head.next;
        return popped;
    }
    
    
}

int peek() {
    if(head==null) {
        System.out.println("Stack empty");
        return 0;
    }
    return head.data;
}

public static void main(String[] args) {
    StackUsingLL sll= new StackUsingLL();
    
    sll.push(10);
    sll.push(20);
    sll.push(30);
    System.out.println(sll.pop()+" popped");
    System.out.println(sll.pop()+" popped");
    System.out.println(sll.pop()+" popped");
    
    System.out.println(sll.isEmpty());
    System.out.println("at top: "+sll.peek());
    
}
