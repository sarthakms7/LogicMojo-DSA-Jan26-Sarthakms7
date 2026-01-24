class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int key = fruits[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            while (map.size() > 2) {
                int newKey = fruits[start++];
                map.put(newKey, map.get(newKey) - 1);
                if (map.get(newKey) == 0) {
                    map.remove(newKey);
                    map.put(key, 1);
                    break;
                }
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}