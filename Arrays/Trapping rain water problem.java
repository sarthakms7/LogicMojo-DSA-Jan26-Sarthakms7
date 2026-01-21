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
        int n = hei.size();
        if(n <= 2) return 0;
        int prevPeak = 0;
        int totalWater = 0;
        //       boolean[] visited = new boolean[n];

        for(int i = 1; i < n; i++) {
            if(hei.get(i) >= hei.get(prevPeak)) {
                if(hei.get(prevPeak) == 0) {
                    prevPeak = i;
                    continue;
                }
                int height = Math.min(hei.get(i), hei.get(prevPeak));
                totalWater += (height * (i - prevPeak - 1));
                for(int j = prevPeak + 1; j < i; j++) {
                    //                  if(visited[j]) continue;
                    totalWater -= hei.get(j);
                    //                  visited[j] = true;
                }
                prevPeak = i;
            }
        }

        prevPeak = n-1;
        for(int i = prevPeak - 1; i >= 0; i--) {
            if(hei.get(i) >= hei.get(prevPeak)) {
                if(hei.get(prevPeak) == 0) {
                    prevPeak = i;
                    continue;
                }
                int height = Math.min(hei.get(i), hei.get(prevPeak));
                totalWater += (height * (prevPeak - i - 1));
                for(int j = prevPeak - 1; j > i; j--) {
                    //                if(visited[j]) continue;
                    totalWater -= hei.get(j);
                    //                visited[j] = true;
                }
                prevPeak = i;
            }
        }

        return totalWater;
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