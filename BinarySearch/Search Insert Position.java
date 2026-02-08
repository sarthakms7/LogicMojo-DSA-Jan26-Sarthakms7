class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target > nums[nums.length-1]) return nums.length;
        if(target < nums[0]) return 0;
        int ans = -1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                ans = mid;
                break;
            } else if(nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}