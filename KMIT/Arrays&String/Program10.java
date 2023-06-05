import java.util.*;
public class Program10{
    static int max(int []arr){
        int n = arr.length;
        int []dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1] + Math.max(arr[i]-arr[i-1],0);

        }
        return dp[n-1];
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] ar=new int[n];
       for(int i=0;i<n;i++){
           ar[i]=sc.nextInt();
       }
       System.out.println(max(ar));
    }

}
