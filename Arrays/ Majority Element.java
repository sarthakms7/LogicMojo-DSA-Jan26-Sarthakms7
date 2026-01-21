class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];

        for(int e: nums) {
            if(e == majorityElement) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                majorityElement = e;
                count = 1;
            }
        }

        return majorityElement;
    }
}