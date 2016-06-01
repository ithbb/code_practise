/*Min Stack*/
/*Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.*/

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> min;
  
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
        
    }

    public void push(int number) {
        if (number <= min()) {
            min.push(number);
        }
        stack.push(number);
 
    }

    public int pop() {
        int val = stack.pop();
        if (val == min()) {
            min.pop();
        }
        return val;
    }

    public int min() {
        if (min.isEmpty()) {
            return Integer.MAX_VALUE;
        }
         return min.peek();

    }
}
