import java.util.*;

public class Program6 {
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    static List<Integer> curr = new ArrayList<Integer>();
    static List<List<Integer>> getPerm(int []arr){
        dfs(arr, new boolean[arr.length]);
        return res;
    }
    static void dfs(int[]arr, boolean[]v){
        if(curr.size()>=arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(v[i]==true || i>0 &&  arr[i]==arr[i-1] && v[i-1]==false) continue;
            v[i]=true;
            curr.add(arr[i]);
            dfs(arr,v);
            v[i]=false;
            curr.remove((Object)arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getPerm(arr));
    }
}