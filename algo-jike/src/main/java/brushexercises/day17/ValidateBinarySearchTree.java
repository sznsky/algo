package brushexercises.day17;

import comm.TreeNode;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/14 18:11
 * [5,4,6,null,null,3,7]
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        //[-2147483648,-2147483648]
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
//        TreeNode root = new TreeNode();
//        root.val = 5;
//
//        TreeNode leftRoot = new TreeNode();
//        leftRoot.val = 4;
//        root.left = leftRoot;
//
//        TreeNode rightRoot = new TreeNode();
//        rightRoot.val = 6;
//        root.right = rightRoot;
//
//
//        TreeNode leftRightRoot = new TreeNode();
//        leftRightRoot.val = 3;
//        rightRoot.left = leftRightRoot;
//
//        TreeNode rightRightRoot = new TreeNode();
//        rightRightRoot.val = 7;
//        rightRoot.right = rightRightRoot;

        TreeNode root = new TreeNode();
        root.val = -2147483648;

        TreeNode leftRoot = new TreeNode();
        leftRoot.val = -2147483648;
        root.left = leftRoot;

        System.out.println(tree.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean check(TreeNode root, long leftRange,long rightRange){
        if(root == null){
            return true;
        }
        //左边的节点的值要小于根节点的值，右边节点的值要大于根节点的值
        if(root.val < leftRange || root.val > rightRange){
            return false;
        }
        //递归注意范围,注意二叉搜索树中，当前根节点一定大于左侧的（所有）节点，一定小于（右侧）所有节点
        boolean leftCheck = check(root.left, leftRange, (long)root.val-1);
        boolean rightCheck = check(root.right, (long)root.val+1, rightRange);
        return leftCheck && rightCheck;
    }
}
