class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int has1_doNothing  = -prices[0];
        int has1_sell       = 0;
        int has0_doNothing  = 0;
        int has0_buy        = -prices[0];

        for(int i = 1; i < len; i++){
            has1_doNothing = has1_doNothing > has0_buy ? has1_doNothing : has0_buy;
            has0_buy = -prices[i] + has0_doNothing;
            has0_doNothing = has1_sell > has0_doNothing ? has1_sell : has0_doNothing;
            has1_sell = prices[i] + has1_doNothing;
        }
        return has1_sell > has0_doNothing ? has1_sell : has0_doNothing;
    }
}
