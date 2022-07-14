package brushexercises.day45;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe :169. 多数元素
 * @Author : sunzhenning
 * @Since : 2022/7/13 20:49
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class NO_169_MajorityElement {

    public static void main(String[] args) {
        NO_169_MajorityElement majorityElement = new NO_169_MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement.majorityElementMole(nums);
        System.out.println(ans);
    }

    /**
     * 摩尔投票法：
     * 思路：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     * @param nums
     * @return
     */
    public int majorityElementMole(int[] nums) {
        int num_init = nums[0];
        //1.从第一个数开始count=1
        int count = 1;
        for(int i=1;i<nums.length;i++){
            //2.遇到相同的就加1
            if(num_init == nums[i]){
                count++;
            }else{
                //3.遇到不同的就减1
                count--;
                if(count == 0){
                    //4.减到0就重新换个数开始计数
                    num_init = nums[i];
                    count = 1;
                }
            }
        }
        return num_init;
    }



    /**
     * Map计数的方法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        double n = nums.length/2;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }
        return -1;
    }

}
