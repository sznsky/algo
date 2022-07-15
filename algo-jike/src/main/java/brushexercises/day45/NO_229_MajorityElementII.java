package brushexercises.day45;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Describe : 229. 多数元素 II
 * @Author : sunzhenning
 * @Since : 2022/7/14 11:39
 */
public class NO_229_MajorityElementII {

    public static void main(String[] args) {
        NO_229_MajorityElementII majorityElementII = new NO_229_MajorityElementII();
        int[] nums = {3,2,3};
        List<Integer> ans = majorityElementII.majorityElement(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }


    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        double n = nums.length/3;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

}
