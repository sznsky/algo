package brushexercises.day31;

import comm.TreeNode;

/**
 * @Describe : leetcode:101 对称二叉树
 * @Author : sunzhenning
 * @Since : 2022/6/29 11:31
 */
public class NO_101_SymmetricTree {

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }


    /**
     * 照镜子思想
     * @param t1
     * @param t2
     * @return
     */
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val) &&isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }


}
