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
     * Complete the 'left_right' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int left_right(List<Integer> arr) {
        int n = arr.size();
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = arr.get(0);
        rightMin[n-1] = arr.get(n-1);

        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr.get(i));
            rightMin[n-1-i] = Math.min(rightMin[n-i], arr.get(n-1-i));
        }

        for(int i = 1; i < n - 1; i++) {
            if(leftMax[i-1] <= arr.get(i) && rightMin[i + 1] >= arr.get(i)) {
                return arr.get(i);
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

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.left_right(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}