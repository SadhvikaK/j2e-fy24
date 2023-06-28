import java.util.*;
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4(int val) {
        this.val = val;
    }
}

public class Program5 {
    public TreeNode4 mergeTree(TreeNode4 root1, TreeNode4 root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTree(root1.left, root2.left);
        root1.right = mergeTree(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode4 p = BinaryTree(sc);
        TreeNode4 q = BinaryTree(sc);
        Program5 sol = new Program5();
        TreeNode4 res = sol.mergeTree(p, q);
        printTree(res);
    }

    private static TreeNode4 BinaryTree(Scanner sc) {
        String[] nodes = sc.nextLine().split(" ");
        return Node1(nodes, 0);
    }

    private static TreeNode4 Node1(String[] nodes, int index) {
        if (index >= nodes.length || nodes[index].equals("-1")) {
            return null;
        }
        TreeNode4 node = new TreeNode4(Integer.parseInt(nodes[index]));
        node.left = Node1(nodes, 2 * index + 1);
        node.right = Node1(nodes, 2 * index + 2);
        return node;
    }

    private static void printTree(TreeNode4 root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode4> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode4 node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}
