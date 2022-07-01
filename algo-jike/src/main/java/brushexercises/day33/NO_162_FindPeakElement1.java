package brushexercises.day33;

/**
 * leetcode:162. 寻找峰值
 */
public class NO_162_FindPeakElement1 {

    public static void main(String[] args) {
        NO_162_FindPeakElement1 findPeakElement = new NO_162_FindPeakElement1();
        int[] nums = {1,2,1,3,5,6,4};
        int ans = findPeakElement.findPeakElement(nums);
        System.out.println(ans);
    }

    /**
     * 思路:三分法求解
     * 注意：在二分法的基础上拓展
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int leftMid = (left + right) / 2;
            int rightMid = leftMid + 1;
            if (nums[leftMid] <= nums[rightMid]) {
                left = leftMid + 1;
            } else {
                right = rightMid - 1;
            }
        }
        return right;

    }
}
