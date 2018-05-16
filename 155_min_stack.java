class MinStack {

    List<Integer> stack = new ArrayList<>();
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        if (!stack.isEmpty()){
            int min = stack.get(0);
            for (Integer val: stack){
                if (val < min) min = val;
            }
            return min;
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
