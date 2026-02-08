class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((m * k) > n) return -1;

        int left = 1, right = Integer.MIN_VALUE;
        for(int e: bloomDay) {
            right = Math.max(right, e);
        }
        int ans = -1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            int maxAdj = 0;
            int i = 0;
            int totalBou = 0;
            while(i < n) {
                if(bloomDay[i] <= mid) {
                    maxAdj++;
                } else {
                    maxAdj = 0;
                }

                i++;
                if(maxAdj == k) {
                    totalBou++;
                    maxAdj = 0;
                }
            }

            if(totalBou >= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}