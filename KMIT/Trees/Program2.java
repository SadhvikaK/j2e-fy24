import java.util.*;
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val) {
        this.val = val;
    }
}
public class Program2 {
    public boolean isSame(TreeNode1 root) {
        if (root == null) {
            return true;
        }
        return Mirror(root.left, root.right);
    }

    private boolean Mirror(TreeNode1 node1, TreeNode1 node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return Mirror(node1.left, node2.right) && Mirror(node1.right, node2.left);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode1 p = constructBinaryTree(sc);
        Program2 sol = new Program2();
        boolean result = sol.isSame(p);
        System.out.println(result);
    }

    private static TreeNode1 constructBinaryTree(Scanner sc) {
        String[] nodes = sc.nextLine().split(" ");
        TreeNode1 root = Node1(nodes[0]);
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode1 curr = queue.poll();
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

    private static TreeNode1 Node1(String val) {
        if (val.equals("-1")) {
            return null;
        }
        return new TreeNode1(Integer.parseInt(val));
    }
}
