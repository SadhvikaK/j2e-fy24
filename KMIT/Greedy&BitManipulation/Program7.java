import java.util.*;
public class Program7{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minXorval(arr));

    }
    public static int minXorval(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i] ^ arr[i+1];
            min = Math.min(min, xor);
        }
        return min;
    }
}