class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i < n; i++) {
            int tempMax = Math.max(Math.max(nums[i], nums[i] * maxSoFar), nums[i] * minSoFar);
            minSoFar = Math.min(Math.min(nums[i], nums[i] * maxSoFar), nums[i] * minSoFar);
            maxSoFar = tempMax;
            maxProd = Math.max(maxSoFar, maxProd);
        }

        return maxProd;
    }
}