package week3.task;

import comm.TreeNode;

import java.util.HashMap;

/**
 * @Describe : leetcode:【106】. 从中序与后序遍历序列构造二叉树
 * @Author : sunzhenning
 * @Since : 2022/6/17 9:57
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class ConstructBinaryTree {

    HashMap<Integer,Integer> inorderArrayMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);//妙啊！将节点值及索引全部记录在哈希表中
        }

        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if(inorderEnd < inorderStart || postorderEnd < postorderStart) return null;

        int root = post[postorderEnd];//根据后序遍历结果，取得根节点
        int rootIndexInInorderArray = inorderArrayMap.get(root);//获取对应的索引

        TreeNode node = new TreeNode(root);//创建该节点
        node.left = buildTree(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = buildTree(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
        return node;//注意！返回的是新建的node！
    }
}
