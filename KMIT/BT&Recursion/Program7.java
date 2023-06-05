import java.util.*;
public class Program7 {
    public static int knapsack(int N, int W, int[] profits, int[] weights) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int W= sc.nextInt();
        int[] profits =new int[N];
        int[] weights = new int[W];
        for(int i=0;i<N;i++){
            profits[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            weights[i]=sc.nextInt();
        }
        int maxProfit = knapsack(N, W, profits, weights);
        System.out.println(maxProfit);
    }
}