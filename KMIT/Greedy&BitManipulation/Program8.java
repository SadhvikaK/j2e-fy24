import java.util.*;
public class Program8{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(singleInteger(arr));

    }
    public static int singleInteger(int[] arr) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ct = 0;
            for (int j = 0; j < arr.length; j++) {
                ct += (arr[j] >> i) & 1;
            }
            if (ct % 2 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}