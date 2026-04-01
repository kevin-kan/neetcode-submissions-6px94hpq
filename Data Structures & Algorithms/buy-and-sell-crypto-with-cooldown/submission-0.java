class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // If you bought before and are selling, you start at 0 profit.
        int selling = 0;
        // If you bought before and are holding, you have negative profit right now.
        int holding = -prices[0];
        // If you sold before and you're on cooldown, you are also at 0 profit 
        int cooling = 0;

        int previousSell;
        for (int i = 1; i < prices.length; i++) {
            previousSell = selling;

            // To be in selling state: you have to be selling the stock you were holding
            selling = holding + prices[i];

            // To be in holding state: you have to buy today (from cooling), or already bought before (holding).
            // You can only buy today if you were in cooling state (not if you just sold or if you're already holding)
            holding = Math.max(holding, cooling - prices[i]);

            // To be in cooling state: you have to have sold yesterday, or maintaining a cooling state.
            cooling = Math.max(cooling, previousSell);

            // State cycle:
            // holding(bought) -> selling -> cooling -> holding
            // holding can move to selling by selling at current price.
            // holding can stay holding by doing nothing.
            // cooling can move to holding by buying at current price.
            // cooling can stay cooling by doing nothing. 
            // selling can move to cooling by keeping the previous sell price. 
        }

        // your best profit will always be after you sold (selling/cooling state) 
        //  never after you just bought & are holding
        return Math.max(selling, cooling);
    }
}
