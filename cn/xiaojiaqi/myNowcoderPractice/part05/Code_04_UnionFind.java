package part05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_04_UnionFind {

	
	public static class Node{
		public int value;
		public Node father;
		public Node(int value) {
			this.value = value;
			father = this;
		}
		public Node(int value,Node father) {
			this.value = value;
			this.father = father;
		}
	}
	public static class UnionFindSet{
		public Map<Node, Integer> sizeMap = new HashMap<>();
		public UnionFindSet(List<Node> list) {
			sizeMap.clear();
			for(Node node : list) {
				node.father = node;
				sizeMap.put(node, 1);
			}
		}
		public Node findFather(Node p) {
			Node father = p.father;
			if(father!=p) {
				father = findFather(father);
			}
			p.father = father;
			return father;
		}
		public boolean isSameSet(Node p,Node q) {
			return findFather(p)==findFather(q);
		}
		public void union(Node p,Node q) {
			if(isSameSet(p, q))return;
			int lenp = sizeMap.get(p);
			int lenq = sizeMap.get(q);
			
			if(lenp>lenq) {
				findFather(q).father = findFather(p);
				sizeMap.put(findFather(q), lenp+lenq);
			}else {
				findFather(p).father = findFather(q);
				sizeMap.put(findFather(p), lenp+lenq);
			}
		}
	}
	

}
