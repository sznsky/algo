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
        int[] nums = {1,-1,-1,0};
        threeNumSum.threeSum(nums);
        System.out.println(Arrays.toString(threeNumSum.ans.toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        set = new HashSet();
        combinations(0, 3, nums);
        return ans;
    }

    private List<List<Integer>> ans;
    private List<Integer> s;
    private Set<String> set;

    public void combinations(int index, int k,int[] nums) {
        if (index >= nums.length || s.size() > 3) {
            return;
        }
        if(nums.length == 3 && sum(nums) == 0){
            ans.add(convert(nums));
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

    /**
     *
     * @param nums
     * @return
     */
    private int sum(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private List<Integer> convert(int[] nums){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }






}
