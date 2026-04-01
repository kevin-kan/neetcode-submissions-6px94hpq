class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(new Pair(val, Math.min(getMin(), val)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().value;
    }
    
    public int getMin() {
        return stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().minimum;
    }
}

class Pair {
    int value;
    int minimum;
    public Pair(int val, int min) {
        value = val;
        minimum = min;
    }
}
