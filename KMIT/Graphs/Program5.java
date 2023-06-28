import java.util.*;
public class Program5 {
    private static class Node {
        int n;
        int row;
        int col;
        public Node(int n, int row, int col) {
            this.n = n;
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        System.out.println(kSmallest(arr, k));
    }

    private static int kSmallest(int[][] arr, int k) {
        int n = arr.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.n - b.n);
        minHeap.offer(new Node(arr[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k-1; i++) {
            Node node = minHeap.poll();
            if (node.row < n-1 && !visited[node.row+1][node.col]) {
                minHeap.offer(new Node(arr[node.row+1][node.col], node.row+1, node.col));
                visited[node.row+1][node.col] = true;
            }
            if (node.col < n-1 && !visited[node.row][node.col+1]) {
                minHeap.offer(new Node(arr[node.row][node.col+1], node.row, node.col+1));
                visited[node.row][node.col+1] = true;
            }
        }
        return minHeap.peek().n;
    }
}