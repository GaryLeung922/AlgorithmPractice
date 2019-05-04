package cn.xiaojiaqi.test;

import java.util.ArrayList;

public class Solution17 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix!=null&&rows*cols==matrix.length&&matrix.length!=0&&str!=null&&str.length>0){
            ArrayList<Integer> starts = new ArrayList<>();
            for(int i=0;i<matrix.length;i++){
                if(matrix[i]==str[0]){
                    starts.add(i);
                }    
            }
            if(starts.size()==0){
                return false;
            }
            for(int i=0;i<starts.size();i++){
                int start = starts.get(i);
                int[] walked = new int[rows*cols];
                for(int j=0;j<walked.length;j++) {
                	walked[j] = 0;
                }
                walked[start] = 1;
                System.out.println(start);
                if(walker(matrix, start, rows, cols, str, 1, walked)) {
                	return true;
                }
            }
            return false;
        }
        return false;
    }
    public static boolean walker(char[] matrix,int cur,int rows,int cols,char[] str,int step,int[] walked){
        if(step==str.length) {//来到
        	return true;
        }
    	int r1 = cur/cols;
        int c1 = cur%cols;
        int next = 0;
        boolean p1=false;
        boolean p2=false;
        boolean p3=false;
        boolean p4=false;
        int[] walkedlist;
        if(r1+1<rows){
            next = (r1+1)*cols+c1;
            if(matrix[next]==str[step]&&walked[next]==0){
                walkedlist = new int[walked.length];
                for(int i=0;i<walked.length;i++) {
                	walkedlist[i] = walked[i];
                }
                walkedlist[next] = 1;
                p1 = walker(matrix,next,rows,cols,str,step+1,walkedlist);
            }
        }
        if(r1-1>=0) {
        	next = (r1-1)*cols+c1;
        	if(matrix[next]==str[step]&&walked[next]==0) {
        		walkedlist = new int[walked.length];
                for(int i=0;i<walked.length;i++) {
                	walkedlist[i] = walked[i];
                }
                walkedlist[next] = 1;
                p2 = walker(matrix,next,rows,cols,str,step+1,walkedlist);
        	}
        }
        if(c1+1<cols) {
        	next = r1*cols+c1+1;
        	//System.out.println(next+"  "+matrix.length+"   "+walked[1]+"  "+step+"  "+str.length);
        	if(matrix[next]==str[step]&&walked[next]==0) {
        		walkedlist = new int[walked.length];
                for(int i=0;i<walked.length;i++) {
                	walkedlist[i] = walked[i];
                }
                walkedlist[next] = 1;
                p3 = walker(matrix,next,rows,cols,str,step+1,walkedlist);
        	}
        }
        if(c1-1>=0) {
        	next = r1*cols+c1-1;
        	if(matrix[next]==str[step]&&walked[next]==0) {
        		walkedlist = new int[walked.length];
                for(int i=0;i<walked.length;i++) {
                	walkedlist[i] = walked[i];
                }
                walkedlist[next] = 1;
                p4 = walker(matrix,next,rows,cols,str,step+1,walkedlist);
        	}
        }
        return p1||p2||p3||p4;
    }
    public static void main(String[] args) {
		String string = "ABCESFCSADEE";
		String string2 = "ABCCED";
		int rows = 3;
		int cols = 4;
		char[] matrix = string.toCharArray();
		char[] str = string2.toCharArray();
		boolean isTrue = hasPath(matrix, rows, cols, str);
		System.out.println(isTrue);
	}


}