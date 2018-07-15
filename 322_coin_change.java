class Solution {

    // Version 1: greedy algorithm
    public int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int minSofar = Integer.MAX_VALUE;    // carray the minimum number of coins
        return coinChange_helper(coins, minSofar, coins.length-1, amount, 0);
    }

    private int coinChange_helper(int[] coins, int minSofar, int idxCoin, int amount, int prevCount){
        int maxCount = amount/coins[idxCoin];
        if(amount % coins[idxCoin] == 0){
            return prevCount+maxCount;
        }
        if(idxCoin==0){
            return -1;
        }

        for (int i = maxCount; i >=0; i--) {
            int newAmount = amount-i*coins[idxCoin];
            int newCount = i + prevCount;
            int nextCoin = coins[idxCoin-1];
            if( newCount + (newAmount + nextCoin - 1 ) / nextCoin < minSofar){   // (newAmount + nextCoin - 1 ) / nextCoin is used for ceiling the result of division
                int res = coinChange_helper(coins, minSofar, idxCoin-1, newAmount, newCount);
                if(res!=-1){
                    minSofar = Math.min(res, minSofar);     // update minSofar when we a solution to make a change
                }
            }
        }
        return minSofar == Integer.MAX_VALUE? -1: minSofar;
    }

    // Version 2: dynamic programming
    // public int coinChange(int[] coins, int amount) {
    //     int[] dp = new int[amount + 1];
    //     dp[0] = 0;
    //     for (int i = 1; i <= amount; i++) {
    //         dp[i] = Integer.MAX_VALUE;
    //         for (int ci = 0; ci < coins.length; ci++) {
    //             if (i - coins[ci] >= 0 && dp[i - coins[ci]] != Integer.MAX_VALUE) {
    //                 dp[i] = Math.min(dp[i], dp[i - coins[ci]] + 1);
    //             }
    //         }
    //     }
    //     return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    // }
}
