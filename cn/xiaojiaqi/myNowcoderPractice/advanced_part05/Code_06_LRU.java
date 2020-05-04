package advanced_part05;

import java.util.HashMap;

public class Code_06_LRU {

	public static class Node {
		int value;
		String str;
		Node next,last;
		public Node(String str,int value) {
			
			this.value = value;
			this.str = str;
		}
		
	}
	
	public static class Lru{
		int capacity;
		HashMap<String, Node> map;
		int size;
		Node front = null;
		Node rear = null;
		public Lru(int capacity) {
			this.capacity = capacity;
			this.map = new HashMap<>();
			this.size = 0;
		}
		public void set(String key,int value) {
			Node p = new Node(key,value);
			map.put(key, p);
			addNode(p);
		}
		private void addNode(Node p) {
			if(this.size>0&&this.size<this.capacity) {
				this.rear.next = p;
				p.last = this.rear;
				this.rear = p;
				size++;
			}else if (this.size==0) {
				this.front = p;
				this.rear = p;
				this.size++;
			}else {
				this.front = this.front.next;
				this.front.last = null;
				this.rear.next = p;
				p.last = this.rear;
				this.rear = p;
			}
		}
		public int get(String key) {
			if(map.containsKey(key)) {
				Node p = map.get(key);
				moveNode(p);
				return p.value;
			}
			throw new RuntimeException("无记录");
		}
		private void moveNode(Node p) {
			if(this.size==1) {
				return;
			}
			if(p==this.front) {
				this.front = p.next;
				this.rear.next = p;
				p.last = this.rear;
				this.rear = p;
				this.rear.next = null;
			}else if (p==this.rear) {
				return;
			}else {
				p.last.next = p.next;
				p.next = null;
				p.last = null;
				this.size--;
				addNode(p);
			}
		}
	}
	public static void main(String[] args) {
		Lru ll = new Lru(3);
		ll.set("A", 9);
		ll.set("B", 99);
		ll.set("C", 4);
		ll.set("D", 6);
		ll.set("E", 0);
		
		System.out.println(ll.get("C"));
	}

}
