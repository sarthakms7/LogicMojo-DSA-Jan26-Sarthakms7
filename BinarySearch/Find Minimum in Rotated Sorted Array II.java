class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        if(n == 1) return nums[0];
        if(nums[n-1] > nums[0]) return nums[0];

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
                right--;
                left++;
            } else if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } else if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                break;
            }
        }

        return nums[left];
    }
}