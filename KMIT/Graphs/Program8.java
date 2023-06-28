

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Program8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(",");
        TreeNode root = build(values, 0);
        Program8 p = new Program8();
        int maxPathSum = p.maxPathSum(root);
        System.out.println(maxPathSum);
    }

    private static TreeNode build(String[] arr, int index) {
        if (index >= arr.length || arr[index].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        node.left = build(arr, 2 * index + 1);
        node.right = build(arr, 2 * index + 2);
        return node;
    }
    int maxpath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxpath;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int path = node.val + left + right;
        maxpath = Math.max(maxpath,path);
        return node.val + Math.max(left, right);
    }
}