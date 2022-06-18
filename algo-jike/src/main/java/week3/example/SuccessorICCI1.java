package week3.example;

import comm.TreeNode;

/**
 * leetcode:面试题 04.06. 后继者
 * 思路：BST树的特性，递归找出结果
 */
public class SuccessorICCI1 {

    /**
     * 递归解决：思路，BST树的中序遍历的结果是单调递增的
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        //当前不可能产生结果
        if(root.val <= p.val){
            return inorderSuccessor(root.right ,p);
        }
        //当第一次出现，root.val > p.val时候，如果root有左子树，那么就是最下层的左子树为p的猴急节点，
        // 否则该节点就是
        TreeNode ans = inorderSuccessor(root.left ,p);
        return ans==null?root:ans;
    }


}
