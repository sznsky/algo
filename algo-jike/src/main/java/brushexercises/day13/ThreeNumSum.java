package brushexercises.day13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @Describe :
* @Author : sunzhenning
* @Since : 2022/6/10 15:38
 * 思路:使用递归，找出所有三个数组合数组，从中找出等于0的数组
*/
public class ThreeNumSum {

    public static void main(String[] args) {
        ThreeNumSum threeNumSum = new ThreeNumSum();
        int[] nums = {13,-11,-14,4,-9,-10,-11,7,-14,-9,14,0,-5,-7,6,-9,11,6,-14,-12,-10,9,-8,-7,5,6,8,-12,-1,-4,14,-3,0,7,9,7,12,13,-9,13,11,-10,-10,-9,-10,12,-10,8,-5,13,11,-8,7,-12,0,-11,2,-14,-8,8,-3,13,-9,5,5,7,-11,-6,5,-13,-7,1,14,-10,-1,-11,-13,4,12,-11,2,0,-4,-14,4,4,-10,13,-3,-10,6,1,-12,4,-9,1,-4,-13,10,8,-11,10,-14,-12,-14,1,-8,10,-10,11,-15,0,-3,-12,1,-14,-1,-1,6,11,-4,-3,-2,-1,-13};
        threeNumSum.threeSum(nums);
        System.out.println(Arrays.toString(threeNumSum.ans.toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        set = new HashSet();
        int[] numsNew = getNums(nums,3);
        combinations(0, 3, numsNew);
        System.out.println(ans.size());
        return ans;
    }

    private List<List<Integer>> ans;
    private List<Integer> s;
    private Set<String> set;

    public void combinations(int index, int k,int[] nums) {
        if(nums.length < k){
            return;
        }
        if (index >= nums.length && s.size() !=k) {
            return;
        }
        if (s.size() == k) {
            int sum = 0;
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> tempS = s;
            //将s排序,拼接，存入set用作判断是否存在（三个元素不分顺序）
            tempS = tempS.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < k; i++) {
                sum += tempS.get(i);
                stringBuilder.append(tempS.get(i));
            }
            if(sum == 0 && !set.contains(stringBuilder.toString())){
                ans.add(new ArrayList<>(tempS));
                set.add(stringBuilder.toString());
            }
            return;
        }
        combinations(index + 1, k, nums);
        s.add(nums[index]);
        combinations(index + 1, k, nums);
        s.remove(s.size() - 1);
    }

    private int[] getNums(int[] nums,int k){
        if(nums.length <= k){
            return nums;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               int val =  map.get(nums[i]);
               if(val < k){
                   map.put(nums[i],val+1);
               }
            }else{
                map.put(nums[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            for(int i=0;i<val;i++){
                list.add(key);
            }
        }
        int[] nums_new = new int[list.size()];
        for(int i =0;i<list.size();i++){
            nums_new[i] = list.get(i);
        }
        return nums_new;
    }






}
