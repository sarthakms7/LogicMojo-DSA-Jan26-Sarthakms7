class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = n + 1;
        int sum = nums[0];

        int left = 0, right = 0;
        while(left <= right && right < n && left >= 0) {
            if(sum >= target) {
                minLen = Math.min(minLen, right-left + 1);
                sum -= nums[left++];
            } else {
                right++;
                if(right == n) break;
                sum += nums[right];
            }
        }

        return minLen == n + 1 ? 0 : minLen;
    }
}