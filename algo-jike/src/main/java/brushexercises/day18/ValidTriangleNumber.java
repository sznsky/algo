package brushexercises.day18;

import java.util.Arrays;

/**
 * @Describe : leetcode:611. 有效三角形的个数
 * @Author : sunzhenning
 * @Since : 2022/6/16 15:12
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        ValidTriangleNumber number = new ValidTriangleNumber();
        int[] nums = {2,2,3,4};
        System.out.println(number.triangleNumber(nums));
    }

    /**
     * 思路：1.组成三角形的边，需要满足两边之和大于第三边，两边之差小于第三边
     * 2.将数组排序（升序）
     * 3、倒序遍历nums，注意边界。
     * 4.如果nums[left]+nums[right]> nums[i],则nums[left+1]..nums[right-1]都满足条件，则有right-left个符合条件。然后right--
     * 5.如果nums[left]+nums[right]<= nums[i],nums[right]已经到尾部了，已经很大了，说明需要nums[left]增加，则需要left++;
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans = ans + (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
