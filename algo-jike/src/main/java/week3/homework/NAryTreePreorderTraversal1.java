package week3.homework;

import comm.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode:589. N 叉树的前序遍历
 * 思路：使用栈来模拟递归
 */
public class NAryTreePreorderTraversal1 {

    /**
     * 存放结果
     */
    private List<Integer> seq;

    /**
     * 使用栈的先进后出模拟N叉树的遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        seq = new ArrayList<>();
        //判断边界
        if(root == null){
            return seq;
        }
        Stack<Node> stack = new Stack<>();
        //将根节点进栈
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            seq.add(node.val);
            List<Node> children = node.children;
            if(children !=null && children.size() > 0){
                for(int i=children.size()-1;i>=0;i--){
                    stack.push(children.get(i));
                }
            }
        }
        return seq;
    }
}
