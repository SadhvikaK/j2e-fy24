import java.util.*;
public class Program15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numDecode(s));
    }

    public static int numDecode(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int ones = Integer.parseInt(s.substring(i - 1, i));
            int twos = Integer.parseInt(s.substring(i - 2, i));
            if (ones >= 1 && ones <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twos >= 10 && twos <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

