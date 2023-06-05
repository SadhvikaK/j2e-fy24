import java.util.*;
public class Program7{
    public static int[] nextGreaterele(int[] arr,int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = nextGreaterele(arr,n);
        System.out.println(Arrays.toString(res));
    }
}