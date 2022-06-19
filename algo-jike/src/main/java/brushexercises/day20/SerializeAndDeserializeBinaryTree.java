package brushexercises.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:207. 课程表
 */
public class SerializeAndDeserializeBinaryTree {

    //出边数组表示图
    private List<List<Integer>> to;

    /**
     * 思路：1.出边数组来表示课程，也就是一个有向图
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        to = new ArrayList<>();
        //遍历每门课程，每门课程[0]表示当前课程，[1]表示当前课程需要依赖的课程
        for(int i=0;i<prerequisites.length;i++){
            int[] pre = prerequisites[i];
            int ai = pre[0];
            int bi = pre[1];


        }

        return false;
    }


}
