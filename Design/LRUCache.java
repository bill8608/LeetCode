public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = nulll;
			this.next = null;
		}
	}
	
	private int capacity;
	private HashMap<Integer, Node> hm = new HashMap<Intger, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}
	
	public int get(int key) {
		if (!hm.containsKey(key)) {
			return -1;
		}
		
		//remove current
		Node current = hm.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		//move current to tail
		move_to_tail(current);
		
		return hm.get(key).value;
	}
	
	public void set (int key, int value) {
		if(get(key) != -1) {
			hm.get(key).value = value;
			return;
		}
		
		if (hm.size() == capacity) {
			hm.remove(head.next.key);
			head.next = head.next.next;
			head.next.pre = head;
		}
		
		Node insert = new Node(key, value);
		hm.put(key,insert);
		move_to_tail(insert);
	}
	
	public void move_to_tail(Node current) {
		current.prev = tail.prev;
		tail.prev = current;
		current.prev.next = current;
		current.next = tail;
	}
}