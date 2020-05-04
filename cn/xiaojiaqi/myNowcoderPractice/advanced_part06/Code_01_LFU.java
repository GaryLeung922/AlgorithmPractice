package advanced_part06;

import java.util.HashMap;

public class Code_01_LFU {
	
	public static class LFU{
		int capacity;//缓存容量
		int size;//当前缓存大小
		LFUNode headOfArr;//缓存头结点,
		HashMap<String, Node> map;//数据存储
		HashMap<Node, LFUNode> help;//存储缓存Node对应的LFUNode
		public LFU(int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.headOfArr = new LFUNode(1);//总保留一个index为1的头结点
			this.map = new HashMap<>();
			this.help = new HashMap<>();
		}
		
		public void put(String key,int value) {
				Node p = new Node(key, value);
				cached(p);
				map.put(key, p);
		}
		public int get(String key) {
			if(map.containsKey(key)) {
				Node p = map.get(key);
				cached(p);
				return p.value;
			}
			//如果map中没有key，则抛出异常
			throw new RuntimeException("无此键："+key);
		}
		//缓存更新P.
		private void cached(Node p) {
			if(help.containsKey(p)) {//如果p在缓存中
				move(p);//p需要移动到index+1的LFUNode结点上去
			}else {//如果p不在缓存中
				if(size>=capacity) {//缓存容量已满，需要移除低活跃度结点
					//由于headOfArr头节点需要保留，所以需要判断headOfArr下的Node链表是否为空
					LFUNode head = headOfArr.headOfNode.next==null?headOfArr.next:headOfArr;
					Node lastNode = head.peekLast();
					delNode(lastNode);
				}else {//未满
					size++;
				}
				add(p);
			}
		}
		//移除一个键值对
		public void remove(String key) {
			if(map.containsKey(key)) {
				Node p = map.get(key);
				map.remove(key);
				if(help.containsKey(p)) {//判断在不在缓存中
					delNode(p);
				}
				return;
			}
			throw new RuntimeException("无此键："+key);
		}
		//当LFUNode结点的Node链表没有元素时，在缓存中移除
		private void delArrNode(LFUNode arrNode) {
			if(arrNode==headOfArr) {//保留headOfArr头节点
				return;
			}else {
				arrNode.last.next = arrNode.next;
				if(arrNode.next!=null) {
					arrNode.next.last = arrNode.last;
				}
				arrNode.next = null;
				arrNode.last = null;
			}
		}
		//缓存中移除p结点
		private void delNode(Node p) {
			help.get(p).del(p);
			if(help.get(p).headOfNode.next==null) {
				delArrNode(help.get(p));
			}
			help.remove(p);
		}
		//在headOfArr结点的Node链表头加上p结点（当新增一个键值对时，进行的操作）
		private void add(Node p) {
			headOfArr.add(p);
			help.put(p, headOfArr);
		}
		//缓存中移动结点。（当重新访问缓存中对象时，执行的操作）
		private void move(Node p) {
			LFUNode un = help.get(p);
			un.move(p);
			help.put(p, un.next);
		}
		
	}
	public static class LFUNode{
		int index;
		LFUNode next;
		LFUNode last;
		Node headOfNode;//头节点时间最新,默认带有一个特殊值Node链表头节点
		public LFUNode(int index) {
			this.index = index;
			this.headOfNode = new Node("null", Integer.MIN_VALUE);
		}
		//LFUNode的Node链表上移除p
		public void del(Node p) {
			p.last.next = p.next;
			if(p.next!=null) {
				p.next.last = p.last;
			}
			p.last = null;
			p.next = null;
		}
		public void move(Node p) {
			if(this.next!=null&&this.index==this.next.index-1) {//如果un不是最后一个链表，并且index+1的链表存在
				p.last.next = p.next;
				if(p.next!=null) {
					p.next.last = p.last;
				}
				this.next.add(p);
				
				
			}else if (this.next!=null&&this.index!=this.next.index-1) {
				LFUNode newList = new LFUNode(this.index+1);
				newList.last = this;
				newList.next = this.next;
				this.next = newList;
				newList.next.last = newList;
				p.last.next = p.next;
				if(p.next!=null) {
					p.next.last = p.last;
				}
				newList.add(p);
				
			}else {
				LFUNode newList = new LFUNode(this.index+1);
				newList.last = this;
				this.next = newList;
				p.last.next = p.next;
				if(p.next!=null) {
					p.next.last = p.last;
				}
				newList.add(p);
			}
			if(this.headOfNode.next==null&&this.last!=null) {
				this.last.next = this.next;
				this.next.last = this.last;
			}
		}
		//Node链表添加一个元素
		public void add(Node p) {
			p.last = this.headOfNode;
			p.next = this.headOfNode.next;
			p.last.next = p;
			if(p.next!=null) {
				p.next.last = p;
			}
			
		}
		//LRUNode的Node链表上最后一个元素（时间最久的）
		public Node peekLast() {
			if(this.headOfNode.next!=null) {
				Node p = this.headOfNode.next;
				while (p.next!=null) {
					p = p.next;
				}
				return p;
			}
			return null;
		}
	}
	public static class Node{
		String key;
		int value;
		Node next;
		Node last;
		public Node(String key,int value) {
			this.key = key;
			this.value = value;
		}
	}
	public static void main(String[] args) {
		LFU lfu = new LFU(3);
		lfu.put("A", 1);
		lfu.put("B", 2);
		lfu.put("C", 3);
		lfu.put("D", 4);
		lfu.put("B", 3);
		System.out.println(lfu.get("B"));
		System.out.println(lfu.get("C"));
		lfu.get("D");
		lfu.get("A");
		lfu.remove("D");
		lfu.remove("A");
		lfu.get("f");
		
	}
}