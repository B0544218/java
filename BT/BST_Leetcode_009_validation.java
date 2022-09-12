/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST_h(root);
    }

    public boolean isValidBST_h(TreeNode node) {
        if (node == null) return true;

        boolean result = true;

        // main logic
        // find the max node in the left side
        if (node.left != null) {
            TreeNode max = findMax(node.left);
            if (max.val >= node.val) {
                result = false;
            }
        }

        // find the min node in the right side
        if (node.right != null) {
            TreeNode min = findMin(node.right);
            if (min.val <= node.val) {
                result = false;
            }
        }

        // data flow
        boolean result_left = isValidBST_h(node.left);
        if (result_left == false) result = false;
        boolean result_right = isValidBST_h(node.right);
        if (result_right == false) result = false;


        return result;
    }

    private static TreeNode findMax(TreeNode root) {
        TreeNode max = null;
        max = root;
        while (true) {
            if (max.right == null) break;
            max = max.right;
        }
        return max;
    }

    private static TreeNode findMin(TreeNode root) {
        TreeNode min = null;
        min = root;
        while (true) {
            if (min.left == null) break;
            min = min.left;
        }
        return min;
    }
}
