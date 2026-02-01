class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int e: nums) {
            nums[Math.abs(e) - 1] *= -1;
        }

        for(int e: nums) {
            if(nums[Math.abs(e) - 1] > 0) {
                ans.add(Math.abs(e));
                nums[Math.abs(e) - 1] *= -1;
            }
        }

        return ans;
    }
}