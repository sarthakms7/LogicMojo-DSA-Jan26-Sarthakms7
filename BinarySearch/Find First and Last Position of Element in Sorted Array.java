class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        int firstIndex = -1, lastIndex = -1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(target == nums[mid]) {
                firstIndex = mid;
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(target == nums[mid]) {
                lastIndex = mid;
                left = mid + 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[] {firstIndex, lastIndex};
    }
}