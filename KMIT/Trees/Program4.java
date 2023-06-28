import java.util.*;
class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int val) {
        this.val = val;
    }
}

public class Program4 {
    public boolean Balanced(TreeNode3 root) {
        return height(root) >= 0;
    }

    private int height(TreeNode3 root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return 1 + Math.max(l, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode3 p = BinaryTree(sc);
        Program4 sol = new Program4();
        boolean res = sol.Balanced(p);
        System.out.println(res);
    }

    private static TreeNode3 BinaryTree(Scanner sc) {
        String[] nodes = sc.nextLine().split(" ");
        TreeNode3 root = Node1(nodes[0]);
        Queue<TreeNode3> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode3 curr = queue.poll();
            if (!nodes[i].equals("-1")) {
                curr.left = Node1(nodes[i]);
                queue.offer(curr.left);
            }
            if (i + 1 < nodes.length && !nodes[i + 1].equals("-1")) {
                curr.right = Node1(nodes[i + 1]);
                queue.offer(curr.right);
            }
        }
        return root;
    }

    private static TreeNode3 Node1(String val) {
        if (val.equals("-1")) {
            return null;
        }
        return new TreeNode3(Integer.parseInt(val));
    }
}

