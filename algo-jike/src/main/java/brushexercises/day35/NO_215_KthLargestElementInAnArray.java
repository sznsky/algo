package brushexercises.day35;

/**
 * leetcode:215. 数组中的第K个最大元素
 * 思路：1.库写好的排序 2.快速排序
 * 本题使用快速排序实现
 */
public class NO_215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        NO_215_KthLargestElementInAnArray kthLargestElementInAnArray = new NO_215_KthLargestElementInAnArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int ans = kthLargestElementInAnArray.findKthLargest(nums,k);
        System.out.println(ans);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    private void quickSort(int[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int pivot = partition(nums,left,right);
        quickSort(nums,left, pivot);
        quickSort(nums,pivot+1, right);
    }

    /**
     * 获取中轴
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums,int left,int right){
        //随机选择中轴
        int pivot = left + (int)Math.random()%(right - left + 1);
        int pivotVal = nums[pivot];
        while (left <= right){
            while (nums[left] < pivotVal) left ++;
            while (nums[right] > pivotVal) right --;
            if(left == right) break;
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        return right;
    }




}
