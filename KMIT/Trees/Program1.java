import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Program1 {
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode p = BinaryTree(sc);
        TreeNode q = BinaryTree(sc);
        Program1 sol = new Program1();
        System.out.println(sol.isSame(p, q));
    }

    private static TreeNode BinaryTree(Scanner sc) {
        String[] nodes = sc.nextLine().split(" ");
        TreeNode root = Node1(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode curr = queue.poll();
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

    private static TreeNode Node1(String val) {
        if (val.equals("-1")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}