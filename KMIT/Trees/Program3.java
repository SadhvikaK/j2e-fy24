import java.util.*;
class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int val) {
        this.val = val;
    }
}

public class Program3 {
    public TreeNode2 invertTree(TreeNode2 root) {
        if (root == null) {
            return null;
        }
        TreeNode2 temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode2 root = BinaryTree(sc);
        Program3 sol = new Program3();
        TreeNode2 invertedRoot = sol.invertTree(root);
        printTree(invertedRoot);
    }

    private static TreeNode2 BinaryTree(Scanner sc) {
        String[] nodes = sc.nextLine().split(" ");
        return Node1(nodes, 0);
    }

    private static TreeNode2 Node1(String[] nodes, int index) {
        if (index >= nodes.length || nodes[index].equals("-1")) {
            return null;
        }
        TreeNode2 node = new TreeNode2(Integer.parseInt(nodes[index]));
        node.left = Node1(nodes, 2 * index + 1);
        node.right = Node1(nodes, 2 * index + 2);
        return node;
    }

    private static void printTree(TreeNode2 root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 node = queue.poll();
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
