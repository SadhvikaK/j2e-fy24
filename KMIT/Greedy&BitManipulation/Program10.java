import java.util.*;
public class Program10{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        System.out.println(reverseBits(x));

    }
    public static long reverseBits(long x) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res |= (x & 1);
            x = x >> 1;
        }
        return res;
    }
}