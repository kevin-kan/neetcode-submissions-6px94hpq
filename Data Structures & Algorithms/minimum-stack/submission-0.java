class MinStack {
    PriorityQueue<Integer> minHeap;
    Stack<Integer> stack;

    public MinStack() {
        minHeap = new PriorityQueue<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        minHeap.add(val);
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        minHeap.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
