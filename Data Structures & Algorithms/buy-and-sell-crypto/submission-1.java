class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            low = Math.min(low, price);
            maxProfit = Math.max(maxProfit, price - low);
        }

        return maxProfit;
    }
}
