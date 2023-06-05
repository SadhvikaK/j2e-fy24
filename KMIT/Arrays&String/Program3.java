import java.util.*;
class Program3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(threesum(arr,target));
    }
    static int threesum(int[] arr,int tar){
        if(arr.length<3){
            return 0;
        }
        int res=arr[0]+arr[1]+arr[arr.length-1];
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++) {
            int st = i + 1, end = arr.length - 1;
            while (st < end) {
                int sum = arr[i] + arr[st] + arr[end];
                if (sum < tar) st++;
                else end--;
                if (Math.abs(sum - tar) < Math.abs(res - tar)) res = sum;
            }
        }
        return res;
    }
}