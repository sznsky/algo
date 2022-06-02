package week1.task;

import java.util.Arrays;

/**
 * leetcode:66
 */
public class PlusOne {


    public static void main(String[] args) {
        //int[] digits = {1,2,3,4,9,9,9};
        int[] digits = {1,2,3,4,1,1,6};
        //int[] digits = {0};
        //int[] digits = {9,9,9,9,9,9,9};
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }


    public int[] plusOne(int[] digits){
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            //找到第一个不是9的元素加1，后面的元素补0
            if(digits[i]!=9){
                digits[i] = digits[i]+1;
                //给当前元素的下一个元素赋值0
                i++;
                while (i <= n-1){
                    digits[i] = 0;
                    i++;
                }
                return digits;
            }
        }
        //都是9，直接数组长度加1，首位为1，其他的为零
        int[] newDigits = new int[n+1];
        newDigits[0] = 1;
        return newDigits;
    }



}
