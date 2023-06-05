import java.util.*;
public class Program2 {
    static int[][] grid;


    public static int countPaths(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        if (grid[i][j] > 0) {
            return grid[i][j];
        }
        int right = countPaths(i, j + 1, m, n);
        int down = countPaths(i + 1, j, m, n);
        int num = right + down;
        grid[i][j] = num;
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        grid = new int[m][n];
        System.out.println(countPaths(0, 0, m, n));

    }
}