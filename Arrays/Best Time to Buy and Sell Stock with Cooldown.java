class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][2];
        return solve(prices, 0, 0, 0);
    }

    public int solve(int[] prices, int curr, int cooldown, int isHolding) {
        if(curr == prices.length) {
            return 0;
        }

        if(cooldown < 0) {
            cooldown = 0;
        }

        if(dp[curr][cooldown][isHolding] != null) {
            return dp[curr][cooldown][isHolding];
        }
        int ans = 0;
        if(isHolding == 1) {
            ans = prices[curr] + solve(prices, curr + 1, 1, 0);
        } else if(cooldown == 0) {
            ans = solve(prices, curr + 1, 1, 1) - prices[curr];
        }

        return dp[curr][cooldown][isHolding] = Math.max(ans, solve(prices, curr + 1, cooldown - 1, isHolding));
    }
}