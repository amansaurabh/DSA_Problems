class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(!mainStack.isEmpty()){
            int popped = mainStack.pop();

            if(popped == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!mainStack.isEmpty()){
            return mainStack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */