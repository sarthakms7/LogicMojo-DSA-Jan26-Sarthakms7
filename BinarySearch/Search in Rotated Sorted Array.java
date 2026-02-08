class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        int pivot = 0;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[n-1]) {
                pivot = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = pivot;
        right = n-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        if(pivot == 0) return -1;

        left = 0;
        right = pivot-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}