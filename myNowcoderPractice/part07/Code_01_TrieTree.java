package part07;

/**
 * 字典树问题
 * @author Narut0
 *
 */
public class Code_01_TrieTree {
	/**
	 * 字典树结点，路径代表相应的字符
	 * @author Narut0
	 *
	 */
	public static class Node{
		int num; //代表以这个结点结尾的字符串的个数
		int path; // 代表经过这个结点的次数
		Node[] next = new Node[26]; //对应的路径依此代表a-z
	}
	public static void main(String[] args) {
		String[] arr1 = {"asd","abc","adsfbs","thjx","abrgw"};
		String[] arr2 = {"abc","asd","thjxs"};
		
		Node head = createTrieTree(arr1);
//		for(int i=0;i<26;i++) {
//			System.out.println(head.next[i]!=null?head.next[i].path:null);
//		}
		String str = "adsfb";
//		for (int i = 0; i < arr2.length; i++) {
//			isAppearce(head, arr2[i]);
//		}
		//isAppearce(head, str);
		prefix(head, str);
		
	}
	/**
	 * 创建字符串数组的字典树
	 * @param arr
	 * @return
	 */
	public static Node createTrieTree(String[] arr) {
		Node head = new Node();
		Node p = head;
		if(arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				String str = arr[i];
				p = head;
				for(int j=0;j<str.length();j++) {
					int index = str.charAt(j)-'a';
					if(p.next[index]!=null) {
						p.next[index].path++;
						
					}else {
						p.next[index] = new Node();
						p.next[index].path++;
					}
					p = p.next[index];
				}
				p.num++;
			}
		}
		return head;
	}
	/**
	 * 如果str在字典树中则输出，否则do nothing
	 * @param head
	 * @param str
	 */
	public static void isAppearce(Node head,String str) {
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(head.next[index]!=null) {
				head = head.next[index];
			}else {
				return;
			}
		}
		if(head.num>0) {//如果上面的循环没有return，说明来到了最后一个结点。
			System.out.println(str);
		}
		
	}
	/**
	 * 如果str为字典树中某个字符串的前缀则打印。
	 * @param head
	 * @param str
	 */
	public static void prefix(Node head,String str) {
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'a';
			if(head.next[index]!=null) {
				head = head.next[index];
			}else {
				return;
			}
		}
		if(head.path>head.num) {
			System.out.println(str);
		}
	}
	

}
