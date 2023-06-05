import java.util.*;
public class Program4 {

    public static void Hanoi(int n, int f, int t, int a) {
        if (n == 1) {
            System.out.println("Move disk from rod " + f + " to rod " + t);
            return;
        }
        Hanoi(n-1, f, a, t);
        System.out.println("Move disk from rod " + f + " to rod " + t);
        Hanoi(n-1, a, t, f);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hanoi(n, 1, 3, 2);
    }
}