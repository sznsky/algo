package week1.task;

import java.util.Arrays;

/**
 * leetcode:641 【设计循环双端队列】
 * 思路：1.使用链表实现 2.使用数组
 * 使用数组两种方式：1.常规方法，左右移动数组 2.使用头指针和尾指针实现
 * 下面使用1方法实现，朴素解法
 */
public class MyCircularDeque {
    /**
     * 数组中实际存储数据的长度
     */
    private int size;
    /**
     * 存放数据数组
     */
    private int[] deque;

    public MyCircularDeque(int k) {
        deque = new int[k];
        size = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        for(int i=size-1;i>=0;i--){
            deque[i+1] = deque[i];
        }
        deque[0] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        deque[size] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        deque[0] = 0;
        for(int i=0;i<size-1;i++){
            deque[i] = deque[i+1];
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        deque[size-1] = 0;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[0];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return deque[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }



}
