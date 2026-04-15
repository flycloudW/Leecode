class LRUCache {
    // 用双向链表哈希表来实现，双向链表把每次put的放在头，这样链表尾就是最不常用的，可以立马找到
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    // 哨兵节点
    private final Node dummy = new Node(0, 0);
    // 哈希表存记录实现查询的O(1)，存key-node键值对
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    // 存初始化的容量
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        // 把node节点放到第一个，先把节点从原位置剥离，再加到前面
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        // 先看是否存在key
        if(!keyToNode.containsKey(key)) {
            Node node = new Node(key, value);
            keyToNode.put(key, node);
            // 把node节点放到第一个，先把节点从原位置剥离，再加到前面
            node.prev = dummy;
            node.next = dummy.next;
            dummy.next.prev = node;
            dummy.next = node;
            // 判断是否超过数量上限
            if(keyToNode.size() > capacity) {
                Node b = dummy.prev;
                keyToNode.remove(b.key); // 必须从 Map 中移除！
                dummy.prev = b.prev;
                dummy.prev.next = dummy;
            }
        } else {
            Node node = keyToNode.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = dummy;
            node.next = dummy.next;
            dummy.next.prev = node;
            dummy.next = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
