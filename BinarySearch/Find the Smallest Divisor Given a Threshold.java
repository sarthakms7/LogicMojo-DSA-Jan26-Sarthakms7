class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1, right = nums[0];
        for(int e: nums) {
            right = Math.max(right, e);
        }

        int ans = right;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(isLessThan(nums, mid, threshold)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean isLessThan(int[] nums, int div, int threshold) {
        int sum = 0;
        for(int e: nums) {
            sum += Math.ceil((double)e/div);
        }

        return sum <= threshold;
    }
}