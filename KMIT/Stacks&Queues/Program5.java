import java.util.*;
public class Program5{

    public static int[] Cards(int n){
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = i + 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(deck[i]);
        }
        int[] arr = new int[n];
        int i = 1, j = 0;
        while (!q.isEmpty()) {
            for (int k = 0; k < i; k++) {
                q.offer(q.poll());
            }
            arr[j++] = q.poll();
            i++;
        }
        for (int k = 0; k < n; k++) {
            if (arr[k] == 0) {
                return new int[]{-1};
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = Cards(n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}