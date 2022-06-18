package week3.example;
import comm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode:297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * 提示： Encodes a tree to a single string.
     * 思路:将二叉树遍历，获取节点值，当节点没有子节点的时候，给null，表示已经结束
     */

    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        dfs(root,seq);
        return String.join(",",seq);
    }
    //遍历二叉树
    private void dfs(TreeNode root,List<String> seq){
        if(root == null){
            seq.add("null");
            return;
        }
        seq.add(String.valueOf(root.val));
        dfs(root.left,seq);
        dfs(root.right,seq);
    }

    /**
     * 提示： Decodes your encoded data to tree.
     */
    //存储字符串分割的数组
    private String[] seq;
    //指针
    private int curr;
    public TreeNode deserialize(String data) {
        seq = data.split(",");
        curr = 0;
        return restore();
    }
    private TreeNode restore(){
        if("null".equals(seq[curr])){
            curr++;
            return null;
        }
        //构建根节点
        TreeNode root = new TreeNode(Integer.parseInt(seq[curr]));
        curr++;
        //递归，先左树，再右树，刚好符合seq数组，存储的顺序。当左数遍历到null就结束了，再来右树
        root.left = restore();
        root.right = restore();
        return root;
    }


}
