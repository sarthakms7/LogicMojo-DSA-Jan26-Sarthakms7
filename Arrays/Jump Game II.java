class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--) {
            dp[i] = n + 1;
            for(int j = 0; j <= nums[i] && (i + j) < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }
        }

        return dp[0];
    }
}

// Greedy Sol (from the solutions tab, not my solution)

class Solution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
}