package brushexercises.day24;

import java.util.*;

/** 40. 组合总和 II-待理解
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/22 12:42
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * candidates = [10,1,2,7,6,1,5], target = 8
 */
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = combinationSumII.combinationSum2(candidates, target);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
        //数组一定要时有序的，才能进行深度递归
        Arrays.sort(candidates);
        //深度递归
        dfs(candidates, len, 0 , target, path, res);
        return res;
    }
    public void dfs(int[] candidates, int len, int dept, int target, Deque<Integer> path, List<List<Integer>> res){
        //如果递归到叶子结点，节点值刚好等于0，那说明路径上的元素就是结果
        if(target == 0){
            //将路径上的结果加入返回结果集上
            res.add(new ArrayList<>(path));
            //退出递归
            return;
        }
        for(int i = dept;i< len; i++){
            //大剪枝，如果在有序的情况下，当前元素已经大于目标数组元素
            //那说明后面的元素就不在需要遍历，原因后面的元素比当前元素更大。
            if(target- candidates[i] < 0){
                break;
            }
            //小剪枝，发生在同层， 可以自己在图上画一个在第一个节点取1后的几种情况就可以发现
            //如果同层的元素的值，相同，就不在需要递归了，
            //原因在有序的情况下，后面出现的元素都会相同，造成结果集也会相同
            if(i> dept && candidates[i] == candidates[i-1]){
                continue;
            }
            //将数组的元素加入路径集合中
            path.addLast(candidates[i]);
            //进行深度递归下一层，所以i+1，
            //这边的重复，允许不同层重复，但是同层不能重复，
            dfs(candidates, len, i+1, target-candidates[i],path,res);
            //剪枝，将元素从末尾开始删除，
            //相当于将树，从叶子结点开始向根结点删除。
            path.removeLast();

        }
    }
}
