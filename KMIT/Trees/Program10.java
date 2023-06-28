import java.util.*;
class TreeNode9 {
    int val;
    TreeNode9 left;
    TreeNode9 right;

    TreeNode9(int x) {
        val = x;
    }
}

class Program10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        TreeNode9 root = conBST(st);
        int val = sc.nextInt();
        TreeNode9 node = searchBST(root, val);
        if (node == null) {
            System.out.println(-1);
        } else {
            printTree(node);
        }
    }

    public static TreeNode9 conBST(String[] st) {
        TreeNode9 root = null;
        for (String value : st) {
            root = insert(root, Integer.parseInt(value));
        }
        return root;
    }

    public static TreeNode9 insert(TreeNode9 root, int val) {
        if (root == null) {
            return new TreeNode9(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static TreeNode9 searchBST(TreeNode9 root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void printTree(TreeNode9 root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}