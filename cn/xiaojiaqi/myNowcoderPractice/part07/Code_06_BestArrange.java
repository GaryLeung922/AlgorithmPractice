package part07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
	题目描述：
	一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目
	的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
	组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会
	议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
	
	
	解题思路：
	以每个项目的结束时间来排序，给出开始时间，
	若项目的开始时间晚于当前开始时间，则这个项目可以安排，然后以这个项目的结束时间来更新开始时间
 * @author Narut0
 *
 */
public class Code_06_BestArrange {

	public static class Program{
		int start;
		int end;
		public Program(int s,int e) {
			this.start = s;
			this.end = e;
		}
	}
	public static class MyComparator implements Comparator<Program>{

		@Override
		public int compare(Program o1, Program o2) {
			
			return o1.end-o2.end;
		}
		
	}
	public static int bestArrange(Program[] p,int start) {
		if(p!=null) {
			Arrays.sort(p,new MyComparator());
			int s = 0;
			for(Program pp:p) {
				if(pp.start>=start) {
					s++;
					start = pp.end;
				}
			}
			return s;
		}
		return 0;
		
	}
	public static void main(String[] args) {
		Program[] p = {new Program(9, 12),new Program(1, 2),new Program(2, 3),new Program(5, 9),new Program(2, 5)};
		System.out.println(bestArrange(p, 1));
	}
	

}
