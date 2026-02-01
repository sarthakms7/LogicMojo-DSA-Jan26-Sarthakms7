import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'median_array' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums1
     *  2. INTEGER_ARRAY nums2
     */

    public static String median_array(List<Integer> nums1, List<Integer> nums2) {
        if (nums1.size() > nums2.size()) {
            return median_array(nums2, nums1);
        }

        int m = nums1.size();
        int n = nums2.size();
        int low = 0, high = m;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1.get(cut1 - 1);
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2.get(cut2 - 1);

            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1.get(cut1);
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2.get(cut2);

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    double median = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                    return String.format(Locale.US, "%.1f", median);
                } else {
                    double median = Math.max(left1, left2);
                    return String.format(Locale.US, "%.1f", median);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return "0.0";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> nums1 = Stream.of(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> nums2 = Stream.of(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.median_array(nums1, nums2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.flush();
    }
}