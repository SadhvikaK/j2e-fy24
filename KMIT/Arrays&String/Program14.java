import java.util.*;
public class Program14{
    static int maxConsOnes(int []arr){
        int i=0,c=1,max=0;
        while(i<arr.length-1){
            if(arr[i]==1 && arr[i+1]==1){
                c++;
                max = Math.max(max,c);
            }
            else{
                c=1;
            }
            i++;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxConsOnes(arr));
    }
}