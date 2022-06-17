package week3.example;

import comm.Node;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode:429. N 叉树的层序遍历
 * 思路：使用队列（先进先出）来解决
 * 层序遍历：也就是广度优先
 */
public class NaryTreeLevelOrderTraversal {

    /**
     * 思路：使用队列解决，先进先出
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        //存放结果
        List<List<Integer>> seq = new ArrayList<>();
        //pair对，存放的是节点信息和层次level
        Queue<Pair<Node,Integer>> queue = new LinkedList<>();
        if(root == null){
            return seq;
        }
        //pair对根节点和第0层信息
        Pair<Node,Integer> rootPair = new Pair<>(root, 0);
        queue.add(rootPair);
        while(!queue.isEmpty()){
            //取出队列中存放节点
            Node node = queue.peek().getKey();
            //当前节点的层级
            Integer level = queue.peek().getValue();
            //将取出的的pair对出列
            queue.poll();
            //如果当前节点的层级大于结果存放的长度，说明要seq要增加长度了
            if(level >= seq.size()){
                seq.add(new ArrayList<>());
            }
            //取出当前节点的值放到seq中
            List<Integer> seqChild = seq.get(level);
            seqChild.add(node.val);
            //将当前节点的子节点放到队列中
            List<Node> children = node.children;
            if(children != null && children.size() > 0){
                for(int i=0;i<children.size();i++){
                    Node child = children.get(i);
                    //层级加1
                    Pair<Node,Integer> childPair = new Pair<>(child, level+1);
                    //加入到队列
                    queue.add(childPair);
                }
            }
        }
        return seq;
    }

}
