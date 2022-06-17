package week3.example;

import comm.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:589. N 叉树的前序遍历
 * 思路：递归方法
 * 前序遍历：根->左->右
 */
public class NAryTreePreorderTraversal {

    /**
     * 存放结果
     */
    private List<Integer> seq;

    public List<Integer> preorder(Node root) {
        seq = new ArrayList<>();
        dfs(root);
        return seq;
    }

    /**
     * 递归遍历：根->依次遍历子集
     * @param root
     */
    private void dfs(Node root){
        if(root == null){
            return;
        }
        seq.add(root.val);
        List<Node> children = root.children;
        for(Node node : children){
            dfs(node);
        }
    }
}
