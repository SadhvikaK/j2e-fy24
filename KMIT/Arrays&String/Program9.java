import java.util.*;
public class Program9{
    static void sort(int []arr){
        int l=0,r=arr.length-1;
        int i=0;
        while(l<r){
            if(arr[l]==0){
                swap(arr, l, i);
                l++; i++;
            }
            else if(arr[l]==1){
                l++;
            }
            else{
                swap(arr, l, r);
                r--;
            }
        }
    }
    static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r]= temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}