package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0)return true;
        //if(numCourses<0||numCourses>2*prerequisites.length)return false; 
        
        int[] course = new int[numCourses];
        Graph graph = new Graph(prerequisites);
        Queue<Node> queue = new LinkedList<>();
        for(Node node : graph.map.values()){
            if(node.in==0){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            Node p = queue.poll();
            //遍历 p 
            if(p.value>=0&&p.value<numCourses){
                course[p.value]=1;
            }
            for(Node node : p.nexts){
                node.in--;
                if(node.in==0)queue.offer(node);
            }
        }
        for(int i=0;i<course.length;i++){
            if(course[i]!=1&&graph.map.containsKey(i))return false;
        }
        
        return true;
    }
    public static class Node{
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public int value;
        public Node(int value){
            this.value = value;
            in=0;
            out=0;
            nexts = new ArrayList<>(); 
        }
    }
    public static class Graph{
        public Map<Integer,Node> map = new HashMap<>();
        
        public Graph(int[][] edges){
            for(int i=0;i<edges.length;i++){
                if(!map.containsKey(edges[i][1]))map.put(edges[i][1],new Node(edges[i][1]));
                Node fromNode = map.get(edges[i][1]);
                if(!map.containsKey(edges[i][0]))map.put(edges[i][0],new Node(edges[i][0]));
                Node toNode =  map.get(edges[i][0]);
                fromNode.out++;
                toNode.in++;
                fromNode.nexts.add(toNode);
                }
        }
    }
    public static void main(String[] args) {
		int numCourses = 3;
		int[][] edges = {{1,0}};
		boolean flag = canFinish(numCourses, edges);
		System.out.println(flag);
		
		List<Integer> list = new LinkedList<>();
		//list.add
		
	}
    
    
}