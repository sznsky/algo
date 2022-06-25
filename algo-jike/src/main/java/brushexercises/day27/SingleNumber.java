package brushexercises.day27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Describe : leetcode:136. 只出现一次的数字
 * @Author : sunzhenning
 * @Since : 2022/6/25 0:06
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        int ans = singleNumber.singleNumber1(nums);
        System.out.println(ans);
    }

    /**
     * 异或：原理还没有搞清楚
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++){

            result = result ^ nums[i];
            System.out.println(result);
        }
        return result;
    }



    /**
     * 使用额外的空间实现
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            Integer count = map.get(num);
            if(count != null){
                map.put(num,count+1);
            }else{
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
