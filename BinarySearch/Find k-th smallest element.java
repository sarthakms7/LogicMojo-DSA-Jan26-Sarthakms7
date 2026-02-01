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
     * Complete the 'kthSmallest' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr1
     *  3. INTEGER m
     *  4. INTEGER_ARRAY arr2
     *  5. INTEGER k
     */

    public static int kthSmallest(int n, List<Integer> arr1, int m, List<Integer> arr2, int k) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < m && p2 < n) {
            if(arr1.get(p1).compareTo(arr2.get(p2)) <= 0) {
                k--;
                if(k == 0) return arr1.get(p1);
                p1++;
            } else {
                k--;
                if(k == 0) return arr2.get(p2);
                p2++;
            }
        }

        while(p1 < m) {
            k--;
            if(k == 0) return arr1.get(p1);
            p1++;
        }

        while(p2 < n) {
            k--;
            if(k == 0) return arr2.get(p2);
            p2++;
        }

        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.kthSmallest(m, arr1, n, arr2, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}