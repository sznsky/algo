package week6.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe : 860. 柠檬水找零
 * @Author : sunzhenning
 * @Since : 2022/7/6 12:39
 */
public class NO_860_LemonadeChange1 {

    public static void main(String[] args) {
        NO_860_LemonadeChange1 lemonadeChange1 = new NO_860_LemonadeChange1();
        int[] bills = {5,5,5,10,20};
        boolean ans = lemonadeChange1.lemonadeChange(bills);
        System.out.println(ans);
    }

    //老板赚的钱存放的位置 面额和每张金额的键值对，就是钱包
    private Map<Integer,Integer> map = new HashMap<>();
    //贪心算法
    public boolean lemonadeChange(int[] bills) {
        //初始化老板的钱包map
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i=0;i<bills.length;i++){
            map.put(bills[i],map.get(bills[i])+1);
            if(!getAmount(bills[i]-5)){
                return false;
            }
        }
        return true;
    }

    //每次需要找零的钱：贪心算法，最大的零钱先找出
    private boolean getAmount(int amount){
        //20元循环找零
        while(amount >= 20 && map.get(20) > 0){
            //20元的张数
            int count = map.get(20);
            amount -= 20;
            map.put(20,count-1);
        }
        //10元循环找零
        while(amount >= 10 && map.get(10) > 0){
            //10元的张数
            int count = map.get(10);
            amount -= 10;
            map.put(10,count-1);
        }
        //5元循环找零
        while(amount >= 5 && map.get(5) > 0){
            //5元的张数
            int count = map.get(5);
            amount -= 5;
            map.put(5,count-1);
        }
        return amount == 0;
    }
}
