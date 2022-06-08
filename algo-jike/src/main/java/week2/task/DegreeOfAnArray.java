package week2.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Describe :leetcode:697 数组的度
 * @Author : sunzhenning
 * @Since : 2022/6/9 1:51
 * 思路：看明白了就不难，总结一下就是要找出数组的众数（出现次数最多的数），并且还有找出众数在数组中第一次出现和最后一次出现的位置，
 *  两个位置组成区间长度就是答案, 如果众数不止一个，那么要取区间长度最短那个
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        int ans = degreeOfAnArray.findShortestSubArray(nums);
        System.out.println(ans);
    }


    /**
     * 1.找出数组中出现次数最多的数（众数）
     * 2.找出众数第一次出现和最后一次出现的位置，返回子数组长度
     * 3.众数有多个的情况下，取出最小的子数组长度
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int ans = 50000;
        int maxCount = 0;
        //存放众数和其对应的下标
        Map<Integer,List<Integer>> map =  new HashMap<>();
        List<Integer> indexList;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                indexList = map.get(nums[i]);
            }else{
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            map.put(nums[i],indexList);
            //找出最大的出现次数
            maxCount = Math.max(maxCount, indexList.size());
        }
        //遍历map,取出数组众数，可能存在多个
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size() == maxCount){
                //众数-出现次数最多的数,第一次和最后一次出现的位置
                Integer firstIndex = list.get(0);
                Integer lastIndex = list.get(list.size()-1);
                //取出某个众数，他首次和最后一次出现的组成的子数组最短
                ans = Math.min(ans,(lastIndex-firstIndex+1));
            }
        }
        return ans;
    }

}
