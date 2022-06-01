package week1.classroom;

/**
 *
 * 88. 合并两个有序数组
 * leetcode:88
 */
public class MergeSortedArray {

    /**
     * 思路：
     * 1.倒序思路，从nums1，nums2的开始的倒序
     * 2.谁大取出谁
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i>=0 || j>=0){
            if(j<0 || (i>=0 && (nums1[i] > nums2[j]))){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    /**
     * 修改语法，使用for循环
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        for(int k = m+n-1; k>=0; k--){
            if(j<0 || (i>=0 && (nums1[i] > nums2[j]))){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
        }
    }


}
