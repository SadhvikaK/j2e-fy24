
import java.util.*;
public class Program6 {
    private static int dfs(int[][] arr, int i, int j, int m, int n, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (grid[i][j] != -1) {
            return grid[i][j];
        }
        int ct = 0;
        if (i + 1 < m) {
            ct += dfs(arr, i + 1, j, m, n, grid);
        }
        if (j + 1 < n) {
            ct += dfs(arr, i, j + 1, m, n, grid);
        }
        grid[i][j] = ct;
        return ct;
    }
    public static int Ways(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(graph[i], -1);
        }
        return dfs(grid, 0, 0, m, n, graph);
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
        System.out.println(Ways(arr));
    }
}