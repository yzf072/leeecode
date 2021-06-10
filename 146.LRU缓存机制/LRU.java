import java.util.HashMap;

public class LRUCache {
    class DLinkedNode{
        int key,value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){
            key=_key;
            value=_value;
        }
    }

    private Map<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;


    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.next=head;
    }
    
    //从hashmap看key的值是否存在，存在找到key映射的DLinkedNode中的值，否则返回-1
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkedNode tail= removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }
    public void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void moveToHead(DLinkedNode node ){
        removeNode(node);
        addToHead(node);
    }
    public DLinkedNode removeTail(){
        DLinkedNode delNode=tail.prev;
        removeNode(delNode);
        return delNode;
    }
    public void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*哈希表+双向链表
哈希表缓存数据的键映射其在双向链表中的位置
添加元素：put
双向链表按照被使用的顺序存储键值对，靠近头部是刚使用的，尾部是最久未使用


执行用时：75 ms, 在所有 Java 提交中击败了9.71%的用户
内存消耗：106.9 MB, 在所有 Java 提交中击败了5.01%的用户
时间：O(1)
空间复杂：O(capacity)
*/