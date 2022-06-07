package week2.classroom;

import comm.TreeNode;

/**
 * leetcode:226 【翻转二叉树】
 * 思路：递归
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
