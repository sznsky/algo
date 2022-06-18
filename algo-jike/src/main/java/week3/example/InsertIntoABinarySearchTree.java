package week3.example;

import comm.TreeNode;

/**
 * leetcode:701. 二叉搜索树中的插入操作
 */
public class InsertIntoABinarySearchTree {

    /**
     * 思路：二叉搜索树的特点：根节点值大于左节点值，小于右节点值
     * 1.如果插入的节点值大于根节点的值，则往右树插入
     * 2.如果插入的节点值小于根节点的值，则往左节点插入
     * 3.如果最后判断，需要在叶子节点插入，那么，要先创建一个节点，然后给这个节点赋值
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //如果这个节点需要插入，但是为空，那么创建一个节点，给节点赋值插入
        if(root == null){
            return new TreeNode(val);
        }
        //注意二叉搜索树的节点值都是唯一的
        if(val > root.val){
            //插入的值大于当前根节点的值，插入到右边，否则插入到左边
            root.right = insertIntoBST(root.right,val);
        }else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

}
