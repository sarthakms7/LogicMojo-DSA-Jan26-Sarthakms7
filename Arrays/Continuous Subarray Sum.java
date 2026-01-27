class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> modFound = new HashMap<>();
        int prefixMod = 0;
        modFound.put(0, -1);

        for(int i = 0; i < n; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if(modFound.containsKey(prefixMod)) {
                if(i - modFound.get(prefixMod) >= 2) {
                    return true;
                }
            } else {
                modFound.put(prefixMod, i);
            }
        }

        return false;
    }
}