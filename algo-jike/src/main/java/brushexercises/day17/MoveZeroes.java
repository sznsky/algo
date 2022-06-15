package brushexercises.day17;

import java.util.Arrays;

/**
 * @Describe : leetcode:283. 移动零
 * @Author : sunzhenning
 * @Since : 2022/6/15 19:51
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路1:遍历-留下不为零的，最后循环补零
     * 1.将不为零的元素留下,使用一个指针n，将不为零的按照n++在nums中依次存储
     * 2.最后将数组nums[n]以后的元素补零
     * 注意：将不为零的元素按照n++在nums中依次存储的时候，会破坏Nums之前的结果，但是不影响最终的结果
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                nums[n] = nums[i];
                n++;
            }
        }
        while (n < nums.length){
            nums[n] = 0;
            n++;
        }
    }

    /**
     * 思路2：双指针
     * 1.定义左右指针l,r，左指针指向已经排好的数组左边,右指针指向初始数组左边
     * 2.r遇到非零的元素，和l指针对应的元素互换，l++.否则l不动。
     * 3.r一直向右++
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                //将left的值赋给临时变量temp
                int temp = nums[left];
                //将right的值赋给left
                nums[left] = nums[right];
                //将temp给right
                nums[right] = temp;
                left ++;
            }
            right++;
        }
    }

}
