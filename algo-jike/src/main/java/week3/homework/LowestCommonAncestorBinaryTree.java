package week3.homework;

import comm.TreeNode;
import javafx.util.Pair;

/**
 * leetcode:236. 二叉树的最近公共祖先（LCA）
 */
public class LowestCommonAncestorBinaryTree {

    /**
     * 思路:遍历二叉树
     * 1.深度优先遍历（递归，前序遍历），找出最大子树，同时存在p和q两个节点
     * 2.第一次同时存在p和q两个节点的子树，就是p和q的最近的公共祖先（LCA）
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private Pair<Boolean,Boolean> dfs(TreeNode root, TreeNode p, TreeNode q){
        //pair对定义的是：p（key）和q(value)是否存在root中（递归的时候，root就是子节点了）
        Pair<Boolean,Boolean> pair = new Pair<>(false,false);
        if(root == null){
            return pair;
        }
        Pair<Boolean,Boolean> leftPair = dfs(root.left,p,q);
        Pair<Boolean,Boolean> rightPair = dfs(root.right,p,q);
        //如果左树中存在p,或者右树中存在p,或者当前节点就是p
        if(leftPair.getKey() || rightPair.getKey() || root.val == p.val){
           pair = new Pair<>(true,pair.getValue());
        }
        //如果左树中存在q,或者右树中存在q,或者当前节点就是q
        if(leftPair.getValue() || rightPair.getValue() || root.val == q.val){
            pair = new Pair<>(pair.getKey(),true);
        }
        if(pair.getKey() && pair.getValue() && ans == null){
            ans = root;
        }
        return pair;
    }


}
