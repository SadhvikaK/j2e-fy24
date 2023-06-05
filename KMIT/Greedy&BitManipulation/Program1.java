import java.util.*;
public class Program1
{
    public static int Steps(int[] arr) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int weight : arr) {
            hs.add(weight);
        }
        return hs.size();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Steps(arr));
    }
}