// Solution 1

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0], sum = 0;
        for(int e: nums) {
            max = Math.max(max, e);
            sum += e;
        }
        int ans = sum;
        int left = max, right = sum;
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(canSplit(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean canSplit(int[] nums, int mid, int k) {
        int sum = 0;
        int splits = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > mid) {
                sum = nums[i];
                splits++;
            }
        }

        return splits + 1 <= k;
    }
}