import java.util.*;
class TreeNode8{
    int val;
    TreeNode8 left;
    TreeNode8 right;
    TreeNode8(int x) {
        val = x;
    }
}

class Program9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        TreeNode8 root = conBST(st);
        int low = sc.nextInt();
        int high = sc.nextInt();
        int sum = rangesumBST(root, low, high);
        System.out.println(sum);
    }

    public static TreeNode8 conBST(String[] st) {
        TreeNode8 root = null;
        for (String value : st) {
            root = insert(root, Integer.parseInt(value));
        }
        return root;
    }

    public static TreeNode8 insert(TreeNode8 root, int val) {
        if (root == null) {
            return new TreeNode8(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static int rangesumBST(TreeNode8 root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangesumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangesumBST(root.left, low, high);
        }
        return root.val + rangesumBST(root.left, low, high) + rangesumBST(root.right, low, high);
    }
}