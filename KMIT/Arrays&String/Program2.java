import java.util.*;
public class Program2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int left=0;
        int right=n-1;
        int max=0;
        while(left<right) {
            int min = Math.min(arr[left], arr[right]);
            int diff = right - left;
            int pro = diff * min;
            max = Math.max(max, pro);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(max);
    }
}
