class Solution {
    public static Map<Character, Character> closeToOpen = new HashMap<>();
    public static Set<Character> openParens = new HashSet<>();

    public Solution() {
        initializeMappings();
    }

    private void initializeMappings() {
        closeToOpen.put(')', '(');
        openParens.add('(');
        closeToOpen.put(']', '[');
        openParens.add('[');
        closeToOpen.put('}', '{');
        openParens.add('{');
    }

    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If it's an open paren, add it to the stack
            if (openParens.contains(c)) {
                parenStack.push(c);
            } 
            // If it's a close paren, confirm that the latest open paren on the stack matches
            else if (closeToOpen.containsKey(c)) {
                if (parenStack.isEmpty() || closeToOpen.get(c) != parenStack.pop()) return false;
            }
            // Otherwise, just skip it. 
        }

        return parenStack.isEmpty();
    }
}
