class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i];
            right[n-i-1] = right[n-i] * nums[n-i-1];
        }

        int[] ans = new int[n];
        ans[0] = right[1];
        ans[n-1] = left[n-2];
        for(int i = 1; i < n - 1; i++) {
            ans[i] = left[i-1] * right[i + 1];
        }

        return ans;
    }
}

// Constant Space

class Solution1 {
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int left = nums[0];
        int right = nums[n-1];

        int[] ans = new int[n];
        ans[0] = 1;
        ans[n-1] = 1;

        for(int i = 1; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        for(int i = n-2; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}