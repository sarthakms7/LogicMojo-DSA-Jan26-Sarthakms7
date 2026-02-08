class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        int left = 1, right = position[n-1] - position[0];

        int ans = 1;
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(canPlace(position, mid, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public boolean canPlace(int[] position, int dis, int m) {
        int balls = 1;
        int lastBall = position[0];
        for(int e: position) {
            if(e >= (lastBall + dis)) {
                balls++;
                lastBall = e;
            }
        }

        return balls >= m;
    }
}