class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenMap = new HashMap<>();
        parenMap.put(')', '(');
        parenMap.put(']', '[');
        parenMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (parenMap.containsValue(c)) stack.push(c);
            else if (parenMap.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != parenMap.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
