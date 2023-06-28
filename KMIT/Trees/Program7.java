import java.util.*;
class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;
    TreeNode6() {
    }
    TreeNode6(int val) {
        this.val = val;
    }
    TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Program7 {
    public int kSmallest(TreeNode6 root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder.get(k - 1);
    }

    private void inorderTraversal(TreeNode6 node, List<Integer> inorder) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        TreeNode6 root = build(nodes);
        int k = sc.nextInt();
        Program7 sol = new Program7();
        int res = sol.kSmallest(root, k);
        System.out.println(res);
    }

    private static TreeNode6 build(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) {
            return null;
        }
        TreeNode6 root = new TreeNode6(Integer.parseInt(nodes[0]));
        Queue<TreeNode6> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode6 node = queue.poll();
            if (!nodes[i].equals("-1")) {
                node.left = new TreeNode6(Integer.parseInt(nodes[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("-1")) {
                node.right = new TreeNode6(Integer.parseInt(nodes[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}