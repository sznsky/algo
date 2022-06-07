package week2.classroom;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制：leetcode:146
 * 思路：1.链表+hash表的实现方式
 * 2.链表是双向链表：有添加和删除方法
 * 3.get方法：根据key到hash表中查找，存在情况下，需要返回该节点数据，然后将该节点添加到链表最前面，同时删除原节点。
 * 4.put方法：1）key不存在，直接把值插入到链表最前面，如果容量超出，删除最后的节点。
 *          2）key存在，更新数据，同时把这个数据放到链表最前面，删除原节点。
 *
 */
public class LRUCache {

    /**
     *
     ["LRUCache","put","put","get","put","get","put","get","get","get"]
     [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     * @param args
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int result = lruCache.get(1);
        System.out.println(result);
        lruCache.put(3,3);
        int result1 = lruCache.get(2);
        System.out.println(result1);

    }
    /**
     * key和Node(存缓存的链表)之间的映射关系
     */
    private Map<Integer, Node> hash;
    /**
     * 链表的头节点
     */
    private Node head;
    /**
     * 链表的尾部节点
     */
    private Node tail;
    /**
     * lru的容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        this.hash = new HashMap<>();
        //头尾保护节点
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hash.get(key);
        if(node == null){
            return -1;
        }
        //删除原节点
        remove(node);
        //将该节点放到链表表头
        insert(head, node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hash.get(key);
        if(node == null){
            //将该节点放到链表表头
            node = new Node();
            node.key = key;
            node.value = value;
            //插入节点
            hash.put(key, node);
            insert(head, node);
            //缓存满了
            if(hash.size() > capacity){
                //删除最后节点tail前一个节点的key（tail是保护节点）
                hash.remove(tail.pre.key);
                //删除hash容器存的key和value
                remove(tail.pre);
            }
        }else{
            node.value = value;
            //删除原节点
            remove(node);
            //插入节点
            insert(head, node);
        }
    }

    /**
     *
     * @param preNode 前一个节点
     * @param node 当前要插入的节点
     */
    private void insert(Node preNode, Node node){
        //preNode节点的下一个节点
        Node nextNode = preNode.next;

        preNode.next = node;
        node.pre = preNode;

        nextNode.pre = node;
        node.next = nextNode;
    }

    /**
     * 删除节点
     * @param node
     */
    private void remove(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    /**
     * 双向链表：key和value
     */
    class Node{
         int key;
         int value;
         Node pre;
         Node next;
    }

}
