class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int e: nums) {
            totalSum += e;
        }

        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(runningSum == (totalSum - runningSum - nums[i])) {
                return i;
            }

            runningSum += nums[i];
        }

        return -1;
    }
}