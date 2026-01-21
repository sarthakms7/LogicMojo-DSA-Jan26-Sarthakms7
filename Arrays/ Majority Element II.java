class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        for(int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e: m.entrySet()) {
            if(e.getValue() > n) {
                ans.add(e.getKey());
            }
        }
        return ans;
    }
}