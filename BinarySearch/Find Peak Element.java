class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        } else {
            if(nums[1] < nums[0]) return 0;
            if(nums[n-2] < nums[n-1]) return n-1;
        }

        return binarySearch(nums, 0, n-1);
    }

    public int binarySearch(int[] nums, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            int prev = (mid - 1) < 0 ? Integer.MIN_VALUE : nums[mid-1];
            int next = (mid + 1) >= nums.length-1 ? Integer.MIN_VALUE : nums[mid + 1];
            if(nums[mid] > prev && nums[mid] > next) {
                return mid;
            } else {
                int leftBinary = binarySearch(nums, left, mid - 1);
                int rightBinary = binarySearch(nums, mid + 1, right);
                return leftBinary == -1 ? rightBinary : leftBinary;
            }
        }

        return -1;
    }
}