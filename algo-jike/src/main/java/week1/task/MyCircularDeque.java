package week1.task;

import java.util.Arrays;

/**
 * leetcode:641 【设计循环双端队列】
 * 思路：1.使用链表实现 2.使用数组
 * 下面使用数组实现
 */
public class MyCircularDeque {

    /**
     * ["MyCircularDeque",
     * "insertFront",
     * "insertLast",
     * "getFront",
     * "insertLast",
     * "getFront",
     * "insertFront",
     * "getRear",
     * "getFront",
     * "getFront",
     * "deleteLast",
     * "getRear"]
     * [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
     */
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(5);
        System.out.println(Arrays.toString(myCircularDeque.deque));
        myCircularDeque.insertFront(7);
        System.out.println(Arrays.toString(myCircularDeque.deque));
        myCircularDeque.insertLast(0);
        System.out.println(Arrays.toString(myCircularDeque.deque));
        myCircularDeque.getFront();
        myCircularDeque.insertLast(3);
        System.out.println(Arrays.toString(myCircularDeque.deque));
        myCircularDeque.getRear();
        myCircularDeque.getFront();
        myCircularDeque.getFront();
        myCircularDeque.deleteLast();
        System.out.println(Arrays.toString(myCircularDeque.deque));
        myCircularDeque.getRear();

    }

    /**
     * 存放队列的数组容器
     */
    private int[] deque;

    /**
     * 从头部进入队列元素的个数
     */
    private int frontSize = 0;
    /**
     * 从尾部进入队列元素的个数
     */
    private int lastSize = 0;



    /**
     * 构造方法:由于值是value >=0的
     * @param k
     */
    public MyCircularDeque(int k) {
        deque = new int[k];
        for(int i = 0;i<k;i++){
            deque[i] = -1;
        }
    }

    //往头部插入一个元素
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if(frontSize == 0){
            deque[0] = value;
            frontSize++;
            return true;
        }
        for(int i=frontSize-1;i>=0;i--){
            deque[i+1] = deque[i];
        }
        deque[0] = value;
        frontSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        if(lastSize == 0){
            deque[deque.length-1] = value;
            lastSize++;
            return true;
        }
        for(int i=deque.length-lastSize;i<deque.length;i++){
            deque[i-1] = deque[i];
        }
        deque[deque.length-1] = value;
        lastSize++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(deque[0] == -1){
            return false;
        }
        deque[0] = -1;
        frontSize--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(deque[deque.length-1] == -1){
            return false;
        }
        deque[deque.length-1] = -1;
        lastSize--;
        return true;
    }

    public int getFront() {
        if(deque[0] != -1){
            return deque[0];
        }
        return -1;
    }

    public int getRear() {
        if(deque[deque.length-1] != -1){
            return deque[deque.length-1];
        }
        return -1;
    }

    public boolean isEmpty() {
        if((frontSize + lastSize) == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if((frontSize + lastSize) == deque.length){
            return true;
        }
        return false;
    }







}
