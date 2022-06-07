package brushexercises.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe : LRU缓存机制：leetcode:146
 * @Author : sunzhenning
 * @Since : 2022/6/7 12:53
 */
public class LRUCache {

    public static void main(String[] args) {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],       [1,1],[2,2],[1],  [3,3], [2], [4,4], [1], [3], [4]]

    }

    private LRCNode head;

    private LRCNode tail;

    private Map<Integer,LRCNode> map;

    private int capacity;

    public LRUCache(int capacity) {
        head = new LRCNode();
        tail = new LRCNode();
        head.nextNode = tail;
        tail.preNode = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LRCNode lrcNode = map.get(key);
        if(lrcNode != null){
            remove(lrcNode);
            insert(head, lrcNode);
            return lrcNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        LRCNode lrcNode = map.get(key);
        if(lrcNode == null){
            lrcNode = new LRCNode();
            lrcNode.key = key;
            lrcNode.value = value;
            insert(head, lrcNode);
            map.put(key, lrcNode);
            if(map.size() > capacity){
                map.remove(tail.preNode.key);
                remove(tail.preNode);
            }
        }else{
            lrcNode.value = value;
            remove(lrcNode);
            insert(head, lrcNode);
        }
    }

    private void insert(LRCNode preNode,LRCNode currentNode){
        //在preNode和nextNode之间插入currentNode
        LRCNode nextNode = preNode.nextNode;

        preNode.nextNode = currentNode;
        currentNode.preNode = preNode;

        currentNode.nextNode = nextNode;
        nextNode.preNode = currentNode;
    }

    private void remove(LRCNode currentNode){
        LRCNode preNode = currentNode.preNode;
        LRCNode nextNode = currentNode.nextNode;
        preNode.nextNode = nextNode;
        nextNode.preNode = preNode;
    }

    class LRCNode{
        int key;
        int value;
        LRCNode preNode;
        LRCNode nextNode;
    }


}
