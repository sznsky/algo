package week2.classroom;

import comm.TreeNode;

public class MaximumDepthOfBinaryTree {

    /**
     * 方法一
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    /**
     * 方法二
     * 递归2
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        ans = 0;
        depth = 1;
        calc(root);
        return ans;
    }

    private void calc(TreeNode root){
        if(root == null){
            return;
        }
        ans = Math.max(ans,depth);
        //深度递增
        ++depth;
        calc(root.left);
        calc(root.right);
        //还原现场
        depth--;
    }

    /**
     * 最终的答案
     */
    private int ans;
    /**
     * 深度
     */
    private int depth;
}
