package week3.example;

import comm.TreeNode;

/**
 * leetcode:后继者
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 思路：中序遍历的后继者
 */
public class SuccessorICCI {

    /**
     * 注意：中序遍历的情况
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return getNext(root, p.val);
    }

    /**
     * 获取下一个节点
     * @return
     */
    private TreeNode getNext(TreeNode root, int val){
        TreeNode ans = null;
        TreeNode curr = root;
        while (curr != null){
            if(curr.val == val){
                if(curr.right != null){
                    //如果右节点不为空，则为右节点就是下一个节点
                    ans = curr.right;
                    //如果当前节点还存在左节点，那么最下层的左节点，才是当前节点的下一个节点
                    while(curr.left != null){
                        ans = curr.left;
                    }
                }
                //要及时结束
                break;
            }
            //注意:二叉搜索树的中序遍历的结果，是单调递增的
            if(curr.val > val){
                //取出，最小的后序遍历的结果，才是最终结果
                if(ans  == null || ans.val > curr.val){
                    ans = curr;
                    //不断的向下遍历
                    curr = curr.left;
                }
            }else{
                //如果，当前节点的值小于给定值，那么只可能给定值节点的左边的值，不可能是结果，只能继续遍历
                curr = curr.right;
            }
        }
        return ans;
    }
}
