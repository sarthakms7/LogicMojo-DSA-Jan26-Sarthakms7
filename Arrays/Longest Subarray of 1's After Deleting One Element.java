class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int start = 0;;
        int k = 1;
        int zeroCount = 0;

        for(int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            while(zeroCount > k) {
                zeroCount -= (nums[start++] == 0 ? 1 : 0);
            }
            maxLen = Math.max(maxLen, i - start);
        }

        return maxLen;
    }
}