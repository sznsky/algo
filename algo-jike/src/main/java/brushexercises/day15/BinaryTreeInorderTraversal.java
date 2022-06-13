package brushexercises.day15;

import comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe : 94. 二叉树的中序遍历
 * @Author : sunzhenning
 * @Since : 2022/6/13 10:56
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class BinaryTreeInorderTraversal {

    private List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    /**
     * 中序遍历：左根右
     * @param root
     */
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

    /**
     * 先序遍历：根左右
     * @param root
     */
    private void dfsPre(TreeNode root){
        if(root == null){
            return;
        }
        ans.add(root.val);
        dfsPre(root.left);
        dfsPre(root.right);
    }

    /**
     * 后序遍历：左右根
     * @param root
     */
    private void dfsLast(TreeNode root){
        if(root == null){
            return;
        }
        dfsLast(root.left);
        dfsLast(root.right);
        ans.add(root.val);
    }








}
