import java.util.*;
public class Program5{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(subs(arr));

    }
    public static List<List<Integer>> subs(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : arr) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> al = new ArrayList<>(res.get(i));
                al.add(num);
                res.add(al);
            }
        }
        return res;
    }
}