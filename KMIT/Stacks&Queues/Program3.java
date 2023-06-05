
import java.util.*;

public class Program3 {
    static List<Integer> Maxnum(int []arr, int k){
        List<Integer> res = new ArrayList<>();
        Queue <Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            q.add(arr[i]);
        }
        res.add(q.peek());
        for(int i=k;i<arr.length;i++){
            q.add(arr[i]);
            q.remove(arr[i-k]);
            res.add(q.peek());
        }
        return res;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Maxnum(arr, k));
    }
}