package week3.example;

import comm.TreeNode;

/**
 * leetcode:1038. 从二叉搜索树到更大和树
 * 思路：1.二叉搜索树，我们第一个想到的是中序遍历，因为中序遍历的结果就是一个递增的数组结果
 * 2.这题我们只需要反着中序遍历即可，当前节点的值等于（当前节点的值+前一个节点的值）
 */
public class BinarySearchTreeToGreaterSumTree {

    private int sum;
    //二叉搜索树中序遍历是左根右。现在反着遍历，右根左，后面的值，需要加上前面的值
    public TreeNode bstToGst(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
