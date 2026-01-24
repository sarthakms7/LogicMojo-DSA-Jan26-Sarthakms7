class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][3][2];
        return solve(prices, 0, 2, 0);
    }

    public int solve(int[] prices, int curr, int maxBuy, int holding) {
        if(maxBuy == -1 || curr == prices.length) {
            return 0;
        }
        if(dp[curr][maxBuy][holding] != null) {
            return dp[curr][maxBuy][holding];
        }
        int ans = 0;
        if(holding == 0) {
            ans = solve(prices, curr + 1, maxBuy - 1, 1) - prices[curr];
        } else {
            ans = prices[curr] + solve(prices, curr + 1, maxBuy, 0);
        }

        return dp[curr][maxBuy][holding] = Math.max(ans, solve(prices, curr + 1, maxBuy, holding));
    }
}