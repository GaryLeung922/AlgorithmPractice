package advanced_part02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 	单调栈结构：
 * 	问题描述：
 * 	在一个arr中可以知道所有数的，左边和右边第一个比它大的数是啥。
 * 	要求：时间复杂度为O(N)
 * @author Narut0
 *
 */

public class Code_02_MonotonousStack2 {
	public static class Num{  //存储一个数的左右两边离它最近且比它大的数
		public int Left;//以下简称左值
		public int Right;//以下简称右值
		public Num(int left,int right) {
			this.Left = left;
			this.Right = right;
		}
		public Num() {
			this.Left = -1;
			this.Right = -1;
		}
	}
	public static class Node{//单调栈内部存储的结构，index为arr数组相应数的索引
		public ArrayList<Integer> index=new ArrayList<>();//数组出现重复值，则压入一个结点
		public Node(int index) {
				this.index.add(index);
		}
	}
	/**
	 * 
	 * @param arr
	 * @return key为对应数组的下标，value为其左右邻近的值
	 */
	public static HashMap<Integer, Num> monotonousStack(int[] arr) {
		if(arr!=null&&arr.length>0) {
			HashMap<Integer, Num> hm = new HashMap<>();
			Stack<Node> stack = new Stack<>();
			int i=0;
			while (i<arr.length) {
				//如果栈不为空，且栈顶元素小于arr[i]，则弹出，并记录其左值（为此时弹出后的栈顶元素,如果为空则置-1）和右值（让其弹出的元素arr[i]）
				while(!stack.isEmpty()&&arr[stack.peek().index.get(0)]<arr[i]) {
					Node tmp = stack.pop();
					for(int j=0;j<tmp.index.size();j++) {//可能有重复值所以需要遍历index
						hm.put(tmp.index.get(j), new Num(stack.isEmpty()?-1:arr[stack.peek().index.get(0)],arr[i]));
					}
				}
				//如果栈非空，且栈顶元素与arr[i]相等，则将index压在一起。
				if(!stack.isEmpty()&&arr[stack.peek().index.get(0)]==arr[i]) {
					stack.peek().index.add(i++);
				}else {//否则 加入新结点
					stack.push(new Node(i++));
				}
				
			}
			//数组遍历完之后，如果栈不为空，则需要依此出栈
			while (!stack.isEmpty()) {
				Node tmp = stack.pop();
				//当前结点的左值为弹出后的栈顶元素（为空则置-1），右值必为-1
				for(int j=0;j<tmp.index.size();j++) {
					hm.put(tmp.index.get(j), new Num(stack.isEmpty()?-1:arr[stack.peek().index.get(0)],-1));
				}
			}
			return hm;
		}
		return null;
	}
	public static void main(String[] args) {
		int[] arr  = {5,3,3};
		HashMap<Integer,Num> map = monotonousStack(arr);
		for(int i=0;i<arr.length;i++) {
			Num num = map.get(i);
			System.out.println(arr[i]+" 索引："+i+" 左值："+num.Left+" 右值："+num.Right);
		}
	}
	

}
