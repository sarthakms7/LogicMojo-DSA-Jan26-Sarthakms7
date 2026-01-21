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
     * Complete the 'majorityElement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int majorityElement(int n, List<Integer> arr) {
        int majorIndex = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr.get(majorIndex) == arr.get(i)) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                majorIndex = i;
                count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < n; i++) {
            if(arr.get(majorIndex) == arr.get(i)) {
                count++;
            }
        }

        if(count > n/2) {
            return arr.get(majorIndex);
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

        int result = Result.majorityElement(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}