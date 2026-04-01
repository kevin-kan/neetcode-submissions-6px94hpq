class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
                int[] t = stack.pop();
                output[t[1]] = i - t[1];
            }
            stack.push(new int[]{currentTemp, i});
        }
        return output;
    }
}
