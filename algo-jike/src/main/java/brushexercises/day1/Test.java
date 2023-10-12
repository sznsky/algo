package brushexercises.day1;


import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception{
        int[] array = {9,6,5,4,2,1,9,7};
        Test.sort(array);
    }

    //这个是之前写的
    public static void sort(int[] array){
        //外层循环控制的是要循环多少次
        for(int i=0;i<array.length-1;i++) {
            //内层循环是两两比较，交换位置，已经排序好的元素不参与比较了。
            //所以是比较次数是array.length-1-i
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("第"+i+"次外循环排序结果："+ Arrays.toString(array));
        }
    }
}
