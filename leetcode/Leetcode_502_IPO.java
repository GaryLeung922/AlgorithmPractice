package cn.xiaojiaqi.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_502_IPO {
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
    	Project[] projects = new Project[Profits.length];
    	//根据capital的小根堆
    	PriorityQueue<Project> minCap = new PriorityQueue<>(new CapComparator());
    	//根据profit的大根堆
    	PriorityQueue<Project> maxPro = new PriorityQueue<>(new ProComparator());
    	for(int i=0;i<projects.length;i++) {
    		projects[i] = new Project(Capital[i], Profits[i]);
    		minCap.add(projects[i]);
    	}
    	while(!minCap.isEmpty()&&minCap.peek().capital<=W){
    		maxPro.add(minCap.poll());
    	}
    	while(k>0) {
    		if(!maxPro.isEmpty()) {
    			W+=maxPro.poll().profit;
        		k--;
        		while(!minCap.isEmpty()&&minCap.peek().capital<=W){
            		maxPro.add(minCap.poll());
            	}
    		}else {
    			break;
    		}
    	}
    	return W;
    }
    public static void main(String[] args) {
		int[] p = {1,2,3};
		int[] c = {0,1,1};
		int k=2;
		int W = 0;
		int res = findMaximizedCapital(k, W, p, c);
		System.out.println(res);
	}
    
    
}
class Project{
	int capital;
	int profit;
	public Project(int c,int p) {
		capital = c;
		profit = p;
	}
}
class CapComparator implements Comparator<Project>{

	@Override
	public int compare(Project o1, Project o2) {
		
		return o1.capital-o2.capital;
	}
	
}
class ProComparator implements Comparator<Project>{

	@Override
	public int compare(Project o1, Project o2) {
		
		return o2.profit-o1.profit;
	}
	
}