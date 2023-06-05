import java.util.*;
public class Program8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(partition(s));

    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private static void backtrack(String s, int start, List<String> temp, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (Palindrome(s, start, i)) {
                    temp.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, temp, res);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private static boolean Palindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}