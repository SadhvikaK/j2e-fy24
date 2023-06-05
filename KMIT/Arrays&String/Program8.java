import java.util.*;
public class Program8 {
    public static int[][] merge(int[][] arr) {
        if (arr.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], arr[i][1]);
            } else {
                merged.add(curr);
                curr = arr[i];
            }
        }
        merged.add(curr);
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int [][]arr ={{1,3},{2,6},{8,10},{15,18}};
        int [][] res = merge(arr);
        for (int[] i : res) {
            System.out.print(Arrays.toString(i) + " ");
        }
    }
}
