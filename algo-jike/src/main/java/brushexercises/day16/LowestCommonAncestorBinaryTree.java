package brushexercises.day16;

import comm.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode:236. 二叉树的最近公共祖先（LCA）
 * 标记法求解
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/14 11:16
 * 思路：1.深度优先遍历root，将（子节点值，父节点）组成键值对，存入到map中
 * 2、取p的值，获取父节点，将p父节点的值存入标记列表set,循环，取出p的所有父节点
 * 3.将q不断的向上循环，取出父节点的值，如果标记set中存在，表示该父节点就是p和q共同的父节点
 */
public class LowestCommonAncestorBinaryTree {

    private Map<Integer,TreeNode> treeNodeMap;
    private Set<Integer> redNodeVal;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        treeNodeMap = new HashMap<>();
        calFather(root);
        redNodeVal = new HashSet<>();
        redNodeVal.add(root.val);
        while(p.val != root.val){
            redNodeVal.add(p.val);
            p = treeNodeMap.get(p.val);
        }
        while (!redNodeVal.contains(q.val)){
            q = treeNodeMap.get(q.val);
        }
        return q;
    }

    private void calFather(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            treeNodeMap.put(root.left.val,root);
            calFather(root.left);
        }
        if(root.right != null){
            treeNodeMap.put(root.right.val,root);
            calFather(root.right);
        }
    }




}
