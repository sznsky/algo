package brushexercises.day13;

import java.util.*;

/**
* @Describe :leetcode:15. 三数之和
* @Author : sunzhenning
* @Since : 2022/6/10 15:38
 * 思路:排序+双指针遍历
*/
public class NO_15_ThreeNumSum1 {

    public static void main(String[] args) {
        NO_15_ThreeNumSum1 threeNumSum = new NO_15_ThreeNumSum1();
        int[] nums = {13,-11,-14,4,-9,-10,-11,7,-14,-9,14,0,-5,-7,6,-9,11,6,-14,-12,-10,9,-8,-7,5,6,8,-12,-1,-4,14,-3,0,7,9,7,12,13,-9,13,11,-10,-10,-9,-10,12,-10,8,-5,13,11,-8,7,-12,0,-11,2,-14,-8,8,-3,13,-9,5,5,7,-11,-6,5,-13,-7,1,14,-10,-1,-11,-13,4,12,-11,2,0,-4,-14,4,4,-10,13,-3,-10,6,1,-12,4,-9,1,-4,-13,10,8,-11,10,-14,-12,-14,1,-8,10,-10,11,-15,0,-3,-12,1,-14,-1,-1,6,11,-4,-3,-2,-1,-13};
        List<List<Integer>> result = threeNumSum.threeSum(nums);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(result.size());
    }

    private List<List<Integer>> ans;

    /**
     * 思路：1.对于数组长度长度为小于3或者为空的情况下，直接返回[]
     * 2.对数组进行排序
     * 3.遍历排序后的数组：
     * 1）若nums[i]>0因为已经排序好了，后面的不可能有三个数相加等于0的情况，直接返回结果
     * 2）对于重复元素，直接跳过，避免出现重复解
     * 3）令左指针L=i+1,右指针R=n-1,当L<R时，执行循环
     * 4）当nums[i]+nums[L]+nums[R]==0的时候，执行循环，判断左边界和有边界是否和下一位重复，去除重复解，同时将L和R移动到
     * 下一个位置，寻找新解
     * 5）若和大于0，说明nums[R]太大，需要左移，
     * 6）若和小于0，说明nums[L]太小，需要右移
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        ans = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                return ans;
            }
            //出现重复元素
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //左指针和右指针的初始位置
            int L = i+1;
            int R = n-1;
            while(L < R){
                if(nums[i]+nums[L]+nums[R] == 0){
                    //不要new一个集合对象，在添加到ans中，下面的操作能够减少部分内存空间
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //出现重复元素
                    while(L < R && nums[L]==nums[L+1]){
                        L++;
                    }
                    //出现重复元素
                    while (L < R && nums[R] == nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if(nums[i]+nums[L]+nums[R] > 0){
                    R--;
                }else{
                    L++;
                }
            }
        }
        return ans;
    }








}
