package brushexercises.day49;

import comm.TreeNode;

/**
 * 337. 打家劫舍 III
 */
public class NO_337_HouseRobberIII {

    /**
     * 递归思想:1.抢劫根节点 2.不抢劫根节点
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[2];
        }
        //递归左节点
        int[] left = dfs(root.left);
        //递归右节点
        int[] right = dfs(root.right);
        int[] ans = new int[2];
        //不抢劫根节点，左右节点随便抢，取出最大的
        ans[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //抢劫根节点，左右节点不能抢
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }
}
