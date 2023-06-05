import java.util.*;
public class Program11{
    static int Peak(int[]arr){
        int n = arr.length;

        if(n==1) return 0;
        if(arr[0]>arr[1])   return 0;
        if(arr[n-1]>arr[n-2])   return n-1;

        int low=0, high=n-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])  return mid;
            else if(arr[mid]<arr[mid+1]){
                low = mid+1;
            }
            else if(arr[mid-1]>arr[mid]){
                high=mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner((System.in));
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Peak(arr));
    }
}