class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] == target) return true;
            else return false;
        }

        int left = 0, right = n-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return true;

            if(nums[mid] == nums[left] && nums[mid] == nums[right]) {
                right--;
                left++;
            } else if(nums[mid] <= nums[right]) {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}