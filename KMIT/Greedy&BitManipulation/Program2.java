import java.util.*;
public class Program2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println(combinations(coins, amount));

    }
    public static int combinations(int[] coins, int amount)
    {
        Arrays.sort(coins);
        int count = 0;
        int remaining = amount;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            while (remaining >= coin) {
                remaining -= coin;
                count++;
            }
            if (remaining == 0) {
                break;
            }
        }
        return remaining == 0 ? count : -1;
    }
}