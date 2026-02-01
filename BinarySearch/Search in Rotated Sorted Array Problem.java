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
     * Complete the 'search_element' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER target
     */

    public static int search_element(List<Integer> arr, int target) {
        int n = arr.size();
        int left = 0, right = n-1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr.get(mid) > arr.get(n-1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int ans = binarySearch(arr, 0, left - 1, target);

        return ans == -1 ? binarySearch(arr, left, n-1, target) : ans;
    }

    public static int binarySearch(List<Integer> arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int target = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.search_element(arr, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}