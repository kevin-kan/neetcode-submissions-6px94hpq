class LRUCache {
    int capacity;
    Map<Integer, Node> hm;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            // Remove it from the doubly linked list
            remove(node);
            // Re-add it to the top of LRU.
            insertFront(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node) {
        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    private void insertFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        temp.prev = node;

        head.next = node;
        node.prev = head;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            remove(hm.get(key)); // remove the old node
            hm.remove(key);
        }
        // Add it to the HashMap;
        Node newNode = new Node(key, value);
        hm.put(key,newNode);

        // Move it to the top of the LRU cache
        insertFront(newNode);

        // Check if we've reached capacity
        if (hm.size() > capacity) {
            // remove from the end of the doubly linked list
            Node lru = tail.prev;
            remove(lru);
            hm.remove(lru.key);
        }
    }
}

// Doubly Linked List Implementation
public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

