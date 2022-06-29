package week3.example;

import comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:94
 * 二叉树的中序遍历
 * 思路:中序遍历：左->根->右
 */
public class NO_94_BinaryTreeInorderTraversal {

    /**
     * 遍历后的结果
     */
    private List<Integer> seq;

    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        seq = new ArrayList<>();
        dfs(root);
        return seq;
    }

    /**
     * 中序遍历:左根右
     * @param root
     */
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    }

    /**
     * 先序遍历：根左右
     * @param root
     */
    private void dfs1(TreeNode root){
        if(root == null){
            return;
        }
        seq.add(root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    /**
     * 后序遍历：左右根
     * @param root
     */
    private void dfs2(TreeNode root){
        if(root == null){
            return;
        }
        dfs2(root.left);
        dfs2(root.right);
        seq.add(root.val);
    }
}
