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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return checkTree(root.left,root.right);
    }
    public static boolean checkTree(TreeNode left,TreeNode right)
    {
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;

        return checkTree(left.left,right.right) 
               && checkTree(left.right,right.left);
    }
}