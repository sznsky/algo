package week4.example;

/**
 * leetcode:153. 寻找旋转排序数组中的最小值
 * 思路：二分不等式
 * 小于等于就是求最大的，前驱类型，大于等于就是求最小的，后继类型
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sortedArray = new FindMinimumInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int ans = sortedArray.findMin(nums);
        System.out.println(ans);
    }

    /**
     * 因为是二分查找，就是O(logn)的时间复杂度
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left+right)/2;
            if(nums[mid] <= nums[right]){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return nums[right];
    }
}
