class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int suffixSum = nums[n-1];
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];

        for(int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1],suffixSum);
        }

        int spSum = nums[0];
        int maxSum = nums[0];
        int currMax = 0;
        int prefixSum = 0;

        for(int i = 0; i < n; i++) {
            currMax = Math.max(currMax, 0) + nums[i];
            maxSum = Math.max(maxSum, currMax);

            prefixSum += nums[i];

            if(i + 1 < n) {
                spSum = Math.max(spSum, prefixSum + rightMax[i + 1]);
            }
        }

        return Math.max(maxSum, spSum);
    }
}