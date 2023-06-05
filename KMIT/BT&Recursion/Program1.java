import java.util.*;
class Program1{
    public static void allStrings(char[] set, int k) {
        int n = set.length;
        allStringsRec(set, "", n, k);
    }

    private static void allStringsRec(char[] set, String prefix, int n, int k) {
        if (prefix.length() == k) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newPrefix = prefix + set[i];
            allStringsRec(set, newPrefix, n, k);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] ch = new char[n];
        for(int i=0; i<n; i++){
            ch[i] = sc.next().charAt(0);
        }
        int k = sc.nextInt();
        allStrings(ch, k);

    }
}