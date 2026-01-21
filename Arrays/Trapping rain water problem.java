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
     * Complete the 'rain_water' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY hei as parameter.
     */

    public static int rain_water(List<Integer> hei) {
        if(hei.size() == 0) return 0;
        int n = hei.size();

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = hei.get(0);
        rightMax[n-1] = hei.get(n-1);

        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], hei.get(i));
        }

        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], hei.get(i));
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - hei.get(i);
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> hei = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.rain_water(hei);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}