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
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER n
     */

    public static int maxProfit(List<Integer> nums, int n) {
        return solve(nums, n, 0, -1);
    }

    public static int solve(List<Integer> nums, int n, int current, int buyIndex) {
        if(current == n) return 0;

        int ans2 = 0;
        int ans5 = 0;
        int ans3 = 0;

        if(buyIndex != -1) {
            int sellValue = nums.get(current) - nums.get(buyIndex);
            ans5 = sellValue + solve(nums, n, current + 1, current);
            ans2 = sellValue + solve(nums, n, current + 1, -1);
        } else {
            ans3 = solve(nums, n, current + 1, current);
        }

        int ans4 = solve(nums, n, current + 1, buyIndex);

        return Math.max(Math.max(ans2, ans5), Math.max(ans3, ans4));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int profit = Result.maxProfit(price, n);

        bufferedWriter.write(String.valueOf(profit));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}