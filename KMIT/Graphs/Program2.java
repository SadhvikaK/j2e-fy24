

import java.util.*;

public class Program2 {
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{arr[i], i});
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || list.get(i)[1] == i) {
                continue;
            }
            int cycle = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = list.get(j)[1];
                cycle++;
            }
            if (cycle > 0) {
                s += cycle - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minSwaps(arr));

    }
}