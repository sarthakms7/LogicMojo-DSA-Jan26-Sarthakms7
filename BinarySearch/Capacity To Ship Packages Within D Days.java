class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int left = weights[0], right = 0;
        for (int e : weights) {
            right += e;
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = 0;
            int currWeight = 0;
            int maxDays = 0;
            boolean shouldContinue = false;
            while (i < n) {
                if(weights[i] > mid) {
                    shouldContinue = true;
                    break;
                }

                currWeight += weights[i];
                if(currWeight > mid) {
                    maxDays++;
                    currWeight = weights[i];
                }
                i++;
            }

            if(shouldContinue) {
                left = mid + 1;
                continue;
            }
            if(currWeight <= mid) maxDays++;

            if(maxDays <= days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}