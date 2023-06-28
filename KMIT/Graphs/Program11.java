import java.util.*;
class Program11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Program11 p = new Program11();
        System.out.println(p.longestIncreasingPath(arr));
    }
    public int longestIncreasingPath(int[][] arr) {
        Integer[][] arr1 = new Integer[arr.length][arr[0].length];
        int l = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                l = Math.max(l, dfs(i, j, -1, arr, arr1));
            }
        }
        return l;
    }

    public int dfs(int row, int col, int parent, int[][] arr, Integer[][] arr1){
        if(row < 0 || row == arr.length || col < 0 || col == arr[0].length ||
                arr[row][col] <= parent){
            return 0;
        }
        if(arr1[row][col] != null){
            return arr1[row][col];
        }
        int up = 1 + dfs(row + 1, col, arr[row][col], arr, arr1);
        int down = 1 + dfs(row - 1, col, arr[row][col], arr, arr1);
        int left = 1 + dfs(row, col - 1, arr[row][col], arr, arr1);
        int right = 1 + dfs(row, col + 1, arr[row][col], arr, arr1);
        int longestPath = Math.max(Math.max(up, down), Math.max(left, right));
        arr1[row][col] = longestPath;
        return longestPath;
    }
}