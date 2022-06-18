package week3.task;

import comm.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describe : leetcode:【106】. 从中序与后序遍历序列构造二叉树
 * @Author : sunzhenning
 * @Since : 2022/6/17 9:57
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class ConstructBinaryTreeInorderPostOrder {

    public static void main(String[] args) {
        ConstructBinaryTreeInorderPostOrder constructBinaryTree = new ConstructBinaryTreeInorderPostOrder();
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        TreeNode treeNode = constructBinaryTree.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recur(inorder, postorder);
    }

    private TreeNode recur(int[] inorder, int[] postorder){
        //终止条件
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        //1.构造根节点(后序遍历最后的一个值就是根节点的值)
        int currentRootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode();
        root.val = currentRootVal;

        //2.找到root节点，在中序遍历的index
        int rootIndex = getRootIndex(inorder,postorder);

        //3.切割用inorder数组：用rootIndex切割inorder，得到inorder的左右半边（左树和右树）
        int[] inorderLeft = Arrays.copyOfRange(inorder,0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder,rootIndex+1, inorder.length);

        //4.切割postorder数组：postorder
        int[] postorderLeft = Arrays.copyOfRange(postorder,0, inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder,inorderLeft.length, postorder.length-1);

        //5.递归
        root.left = recur(inorderLeft, postorderLeft);
        root.right = recur(inorderRight, postorderRight);
        return root;
    }

    private int getRootIndex(int[] inorder, int[] postorder){
        int rootVal = postorder[postorder.length-1];
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                return i;
            }
        }
        return 0;
    }


}
