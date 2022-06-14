package stack;

import java.util.*;

public class MinStack {

    static class MinStackNode{
        int val;
        int min;
        public MinStackNode(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<MinStackNode> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.add(new MinStackNode(val, val));
        }else{
            var topVal = stack.peek();
            if(topVal.min > val){
                stack.add(new MinStackNode(val, val));
            }else{
                stack.add(new MinStackNode(val, topVal.min));
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

}
