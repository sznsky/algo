package week4.example;

/**
 * leetcode:162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1,2,1,3,5,6,4};
        int ans = findPeakElement.findPeakElement(nums);
        System.out.println(ans);
    }

    /**
     * 思路：三分法求解峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left =0;
        int right = nums.length-1;
        while (left <right){
            int leftMid = (left+right) / 2;
            int rightMid = leftMid + 1;
            if(nums[leftMid] <= nums[rightMid]){
                left = leftMid +1;
            }else{
                right = rightMid - 1;
            }
        }
        return right;
    }
}
