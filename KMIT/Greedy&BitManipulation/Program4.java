import java.util.*;
public class Program4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minPills(n, v, arr));

    }
    public static int minPills(int N, int V, int[] arr) {
        int pills = 0;
        int health = V;
        for (int i = 0; i < N; i++) {
            if (health <= 0) {
                break;
            }
            else if (arr[i] >= health) {
                pills++;
                health = health + arr[i];
            }
            else {
                health--;
            }
        }
        return pills;
    }
}