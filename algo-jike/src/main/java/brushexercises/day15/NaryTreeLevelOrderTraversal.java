package brushexercises.day15;

import comm.Node;
import javafx.util.Pair;

import java.util.*;

/**
 * @Describe :leetcode:429 N叉树的层级遍历
 * @Author : sunzhenning
 * @Since : 2022/6/13 15:35
 */
public class NaryTreeLevelOrderTraversal {

    /**
     * 思路：1.层级遍历，先遍历第一层（root）,再遍历第二层,...第N层
     * 2.使用队列queue先进先出的特性来解决
     * 3.节点出队列的时候，同时将子节点放到队列，只要队列不为空，一直循环遍历出队列
     * 4.细节处理，答案是二维数组，外层数组的下标就是对应队列的层级
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        //存放结果
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        //使用链表实现队列，pair对存储树的节点和层级，后面后用到
        Queue<Pair<Node,Integer>> queue = new LinkedList<>();
        Pair<Node,Integer> rootPair = new Pair<>(root, 0);
        queue.add(rootPair);
        while (!queue.isEmpty()){
            //当前节点出列
            Pair<Node,Integer> pair = queue.poll();
            //当前节点
            Node node = pair.getKey();
            //当前节点层级
            Integer level = pair.getValue();
            //存放答案的ans的长度应该和level+1的长度是一致的，注意：level从0开始的。
            if(ans.size() < level+1){
                ans.add(new ArrayList<>());
            }
            //将当前节点值存入答案集合
            List<Integer> s = ans.get(level);
            s.add(node.val);
            //当前节点存在子节点
            if(node.children != null && node.children.size() > 0){
                for(int i=0;i<node.children.size();i++){
                    Node childNode = node.children.get(i);
                    //子节点的节点和层级存入队列
                    queue.add(new Pair<>(childNode,level+1));
                }
            }
        }
        return ans;
    }


}
