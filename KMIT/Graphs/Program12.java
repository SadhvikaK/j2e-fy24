
import java.util.*;
class Program12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minSteps(arr));
    }
    public static int minSteps(int[] arr) {
        int n = arr.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                graph.get(i).add(j);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] steps = new int[n];
        queue.offer(0);
        visited[0] = true;
        steps[0] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n - 1) {
                return steps[curr];
            }
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    steps[neighbor] = steps[curr] + 1;
                }
            }
        }
        return -1;
    }
}