import java.util.*;
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> result = FBT(n);
        for (Node root : result) {
            printTree(root);
            System.out.println();
        }

    }

    public static List<Node> FBT(int n) {
        List<Node> res = new ArrayList<>();
        if (n == 1) {
            res.add(new Node(0));
            return res;
        }
        for (int i = 1; i < n; i += 2) {
            List<Node> leftSubtrees = FBT(i);
            List<Node> rightSubtrees = FBT(n - i - 1);
            for (Node left : leftSubtrees) {
                for (Node right : rightSubtrees) {
                    Node root = new Node(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}