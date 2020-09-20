package cn.xiaojiaqi.sword2Offer;
/**
 * 
 */
import cn.xiaojiaqi.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Main01{
    public static TreeNode treeByPre(String pre){
        if(pre==null||pre.length()==0)return null;
        
        Queue<String> queue = new LinkedList<>();
        for(char ch:pre.toCharArray()){
            queue.offer(ch+"");
        }
        return treeByPre(queue);
    }
    public static TreeNode treeByPre(Queue<String> queue){
        String value = queue.poll();
        TreeNode root = value.equals("#") ? null : new TreeNode(value.charAt(0));
        if(root==null)return root;
        root.left = treeByPre(queue);
        root.right = treeByPre(queue);
        return root;
    }
    public static void travel_In(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null) {
            	stack.push(p);
            	p = p.left;
            }else {
            	p = stack.pop();
            	System.out.print(p.val+" ");
            	p = p.right;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pre;
        while(sc.hasNext()){
            pre = sc.nextLine();
            TreeNode root = treeByPre(pre);
            travel_In(root);
            
        };
    }
}