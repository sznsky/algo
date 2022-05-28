package sort;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/5/25 20:29
 */
public class QuickSortNew {

    public static void quickSort(int[] array){
        if (array == null || array.length < 2) {
            return;     //array为空或者该数组元素为一，没有排序的意义
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int l, int r) {
        if ( l >= r){
            return;     //数据不合法，退出程序
        }
        //要向使l --> r中有序，先找到一个基准数,取数组的最后一个数为基准数
        int num = array[r];
        //找到基准数在数组中的位置，使得 < 基准数的在左边 ,等于基准数的在中间, > 基准数的在右边。
        int[] index = quick_sort(array, l, r,num);  //此时中间的 = sum的已经拍好序了
        quickSort(array,l,index[0]);        //使左边的有序
        quickSort(array,index[1],r);        //使右边的有序

    }

    private static int[] quick_sort(int[] array, int l, int r, int num) {
        //找到基准数在数组中的位置，使得 < 基准数的在左边 ,等于基准数的在中间, > 基准数的在右边。
        int p1 = l - 1;
        int p2 = r + 1;
        while (l < p2) {
            if (array[l] < num){
                //1.第一种情况，如果小于num的时候，将该元素与 < 范围的前一个交换，i++
                int temp = array[l];
                array[l] = array[p1 + 1];
                array[p1 + 1] = temp;
                l++;
                p1++;
            }else if (array[l] == num){
                //2.第二种情况，如果[l]==sum的时候，l++
                l++;
            }else {
                //3.第三种情况,如果[l] > sum的时候，[l] 与 > 范围的前一个元素交换
                int temp = array[l];
                array[l] = array[p2 - 1];
                array[p2 - 1] = temp;
                p2--;
            }
        }
        return new int[]{p1,p2};    //此时中间的 = sum的已经拍好序了、
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,3,6,3,5,8,10,3};
        quickSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
