import java.util.*;
public class Program7{
    static int getMax(int []arr){
        int n=arr.length;
        int []dpsum = new int[n];
        int []dpmax = new int[n];
        dpsum[0]=dpmax[0]=arr[0];
        for(int i=1;i<n;i++){
            dpsum[i]= Math.max(dpsum[i-1]+arr[i],arr[i]);
            dpmax[i]=   Math.max(dpmax[i-1],dpsum[i]);
        }
        return dpmax[n-1];
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
        System.out.println(getMax(arr));
    }
}