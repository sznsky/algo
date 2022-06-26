package week4.task;

/**
 * leetcode:154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须尽可能减少整个过程的操作步骤。
 */
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII ii = new FindMinimumInRotatedSortedArrayII();
        int[] nums = {2,2,2,0,1};
        int ans = ii.findMin(nums);
        System.out.println(ans);
    }

    /**
     * 思路：原来是单调递增的，经过旋转，数组分为了两部部分，都是单调递增的（右重复，但是近似单调递增）
     * 二分不等式，求大于等于中的最小值，也就是>=target的最小值，后继类型
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left =0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right --;
            }
        }
        return nums[left];
    }

}
