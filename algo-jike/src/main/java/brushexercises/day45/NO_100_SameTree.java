package brushexercises.day45;

import comm.TreeNode;

/**
 * @Describe : 100. 相同的树  
 * @Author : sunzhenning
 * @Since : 2022/7/13 19:30
 */
public class NO_100_SameTree {

    /**
     * 递归
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }



}
