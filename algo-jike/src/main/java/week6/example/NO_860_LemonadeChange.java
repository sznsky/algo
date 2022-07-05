package week6.example;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:860. 柠檬水找零
 */
public class NO_860_LemonadeChange {


    public static void main(String[] args) {
        NO_860_LemonadeChange lemonadeChange = new NO_860_LemonadeChange();
        int[] bills = {5,5,10,10,20};
        boolean ans = lemonadeChange.lemonadeChange(bills);
        System.out.println(ans);
    }

    /**
     * 老板手上的钱：三种零钱各自的个数
     */
    private Map<Integer,Integer> map = new HashMap<>();
    /**
     * 思路：1.由于零钱是20，10，5三种类型，零钱由大到小具有决策的包容性，比如，找出20，必然包含2个10元，10元包含2个五元
     * 2.使用map存储三种零钱的个数。
     * 3.在bill进账的同时，使用贪心算法找零。
     * 4.贪心算法中，map对应的零钱的个数减少。
     * 5.每次找零的同时，要减去一杯奶茶的钱。
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        //初始老板手上的钱
        map.put(20,0);
        map.put(10,0);
        map.put(5,0);
        for(int bill : bills){
            map.put(bill,map.get(bill)+1);
            //bill-5 就是老板需要找的钱，如果顾客给出5元，老板就不需要找钱。
            if(!exchange(bill - 5)){
                return false;
            }
        }
        return true;
    }

    /**
     * 找零
     * @param amount 要找零的钱
     * @return boolean
     */
    private boolean exchange(int amount){
        //使用贪心算法，从最大的开始找
        while (amount >= 20 && map.get(20) > 0){
            int count = map.get(20);
            amount = amount-20;
            map.put(20,count-1);
        }
        while (amount >= 10 && map.get(10) > 0){
            int count = map.get(10);
            amount = amount-10;
            map.put(10,count-1);
        }
        while (amount >= 5 && map.get(5) > 0){
            int count = map.get(5);
            amount = amount-5;
            map.put(5,count-1);
        }
        //刚好找完
        return amount == 0;
    }

}
