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
     * Complete the 'longestSubstringWithoutRepeatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        if(n == 0) return 0;

        int ans = 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        int i = 0;
        for(Character c: s.toCharArray()) {
            if(!set.contains(c)) {
                count++;
                set.add(c);
                ans = Math.max(ans, count);
            } else {
                while(i < n && set.contains(c)) {
                    set.remove(s.charAt(i++));
                    count--;
                }
                set.add(c);
                count++;
            }
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.longestSubstringWithoutRepeatingCharacters(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}