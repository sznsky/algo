package week2.classroom;

import comm.TreeNode;

/**
 * leetcode:98 【验证二叉搜索树】
 * 思路：递归
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode();
        root.val = 5;

        TreeNode leftRoot = new TreeNode();
        leftRoot.val = 4;
        root.left = leftRoot;

        TreeNode rightRoot = new TreeNode();
        rightRoot.val = 6;
        root.right = rightRoot;


        TreeNode leftRightRoot = new TreeNode();
        leftRightRoot.val = 3;
        rightRoot.left = leftRightRoot;

        TreeNode rightRightRoot = new TreeNode();
        rightRightRoot.val = 7;
        rightRoot.right = rightRightRoot;



        System.out.println(tree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //由于没有给定范围，开始最大的范围
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean check(TreeNode root,long leftRange,long rightRange){
        System.out.println("root:"+(root!=null?root.val:null)+",leftRange:"+leftRange+",rightRange:"+rightRange);
        //节点为空，说明遍历到最底层了，没有出现不符合条件的情况，返回true
        if(root == null){
            System.out.println(true);
            return true;
        }
        //这个就是不符合二叉搜索树条件的情况
        if(root.val < leftRange || root.val > rightRange){
            System.out.println(false);
            return false;
        }
        //左右节点分别递归，需要注意条件：左树的值一定比root节点的值小，右树的值一定要比root节点的值大
        boolean bLeft = check(root.left,leftRange,(long)root.val-1);
        boolean bRight = check(root.right, (long)root.val+1,rightRange);
        System.out.println("&&:"+(bLeft && bRight));
        return bLeft && bRight;
    }

}
