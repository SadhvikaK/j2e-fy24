import java.util.*;
public class Program4
{
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
        System.out.println(numIsland(arr));
    }
    public static int numIsland(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ct = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    dfs(arr, i, j);
                    ct++;
                }
            }
        }
        return ct;
    }
    private static void dfs(int[][] matrix, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j] = -1;
        dfs(matrix, i+1, j);
        dfs(matrix, i-1, j);
        dfs(matrix, i, j+1);
        dfs(matrix, i, j-1);
    }

}