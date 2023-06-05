import java.util.*;
public class Program9{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(hammingDistance(m, n));

    }
    public static int hammingDistance(int m, int n) {
        int xor = m ^ n;
        int ct = 0;
        while (xor > 0) {
            ct += xor & 1;
            xor >>= 1;
        }
        return ct;
    }
}