package brushexercises.day17;

import comm.TreeNode;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/14 18:11
 * [5,4,6,null,null,3,7]
 */
public class ValidateBinarySearchTree {


    private boolean ans;
    public boolean isValidBST(TreeNode root) {
        ans = true;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if(leftNode!=null && leftNode.val >= root.val && ans){
            ans = false;
            return;
        }
        if(rightNode != null && rightNode.val <= root.val && ans){
            ans = false;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
