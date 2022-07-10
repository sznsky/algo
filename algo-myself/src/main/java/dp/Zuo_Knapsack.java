package dp;

/**
 * 经典的背包问题：
 */
public class Zuo_Knapsack {

    public static void main(String[] args) {
        Zuo_Knapsack knapsack = new Zuo_Knapsack();
        int[] w = {3,2,4,7};
        int[] v = {5,6,3,19};
        int bag = 11;
        System.out.println(maxValue(w,v,bag));
    }

    /**
     * 求出背包货物的最大价值
     * @param w 背包中货物的价值
     * @param v 货物的价值
     * @param bag 背包的所能承担的总重量
     * @return
     */
    public static int maxValue(int[] w,int[] v,int bag){
        if(w == null || w.length == 0 || v == null || v.length == 0 || bag ==0){
            return 0;
        }
        //尝试函数
        return process(w,v,0,bag);
    }

    /**
     * 尝试函数：所有的货物都可以自由选择：可以选择，可以不选择
     * @param w
     * @param v
     * @param index
     * @param bag
     * @return 返回背包里面货物的最大价值
     */
    public static  int process(int[] w,int[] v,int index,int bag){
        //背包装不下货物了，无效解
        if(bag < 0){
            return -1;
        }
        //没有货物了
        if(index == w.length){
            return 0;
        }
        //不要当前的货
        int p1 = process(w,v,index+1,bag);
        //要当前的货：当前背包的中货物的价值=当前货物+递归调用，背包的重量要减少
        int p2 = 0;
        int next = process(w,v,index+1,bag - w[index]);
        //无效解
        if(next != -1){
            p2 = v[index] + next;
        }
        return Math.max(p1,p2);
    }

}
