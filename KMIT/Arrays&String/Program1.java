import java.util.*;

public class Program1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dup=new int[n];
        boolean[] arr1=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            dup[i]=arr[i];
        }
        Arrays.sort(dup);
        int extra=sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i]+=extra;
            if(arr[i]>=dup[n-1]){
                arr1[i]=true;
            }
            else{
                arr1[i]=false;
            }
            arr[i]-=extra;
        }
        System.out.println(Arrays.toString(arr1));
    }
}
