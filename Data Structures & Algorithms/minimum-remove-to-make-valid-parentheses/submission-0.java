class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] sChars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '(') {
                stack.push(i);
            } else if (sChars[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sChars[i] = '\0'; // mark the close parens that need to be removed
                }
            }
        }

        while (!stack.isEmpty()) {
            sChars[stack.pop()] = '\0'; // mark the open parens that need to be removed
        }

        StringBuilder result = new StringBuilder();
        for (char c : sChars) {
            if (c != '\0') {
                result.append(c);
            }
        }

        return result.toString();
    }
}