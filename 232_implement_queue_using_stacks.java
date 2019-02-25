class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.size() != 0) {
            return outStack.pop();
        }
        // move all from inStack to outStack
        while (inStack.size() != 0) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.size() != 0) {
            return outStack.peek();
        }
        // move all from inStack to outStack
        while (inStack.size() != 0) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.size() == 0 && outStack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
