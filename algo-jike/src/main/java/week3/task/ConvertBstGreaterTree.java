package week3.task;

import comm.TreeNode;

/**
 * @Describe : leetcode:538. 把二叉搜索树转换为累加树
 * @Author : sunzhenning
 * @Since : 2022/6/17 10:03
 */
public class ConvertBstGreaterTree {

    private int sum;
    //二叉搜索树中序遍历是左根右。现在反着遍历，右根左，后面的值，需要加上前面的值，累加，赋值
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
