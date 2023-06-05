import java.util.*;

public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Subsets(arr, n);

    }

    public static void Subsets(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        List<Integer> subset = new ArrayList<>();
        helper(arr, n, sum, 0, subset);
        Collections.sort(subset);
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
    }

    public static void helper(int[] arr, int n, int sum, int index, List<Integer> subset) {
        if (index == n) {
            subset.add(sum);
            return;
        }
        helper(arr, n, sum, index + 1, subset);
        sum -= arr[index];
        helper(arr, n, sum, index + 1, subset);
    }
}