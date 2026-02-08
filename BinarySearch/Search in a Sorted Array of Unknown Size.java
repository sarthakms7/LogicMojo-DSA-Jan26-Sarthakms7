/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 10000 - 1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            int midNum = reader.get(mid);
            if(midNum == Integer.MAX_VALUE) {
                right = mid - 1;
            } else if(midNum == target) {
                return mid;
            } else if(target < midNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}