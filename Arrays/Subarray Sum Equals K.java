class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] == k) return 1;
            else return 0;
        }

        int sum = 0;
        int count = 0;

        Map<Integer, Integer> sumOccurCount = new HashMap<>();
        sumOccurCount.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sumOccurCount.containsKey(sum - k)) {
                count += sumOccurCount.get(sum - k);
            }

            sumOccurCount.put(sum, sumOccurCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}