package cn.xiaojiaqi.test;

import java.util.Arrays;

public class Solution26 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
    	int[] newarr = Arrays.copyOf(sequence, sequence.length);
    	Arrays.sort(newarr);
        return verify(sequence, newarr, 0, sequence.length-1, 0, sequence.length-1);
    }
    public static boolean verify(int[] posOrder,int[] inOrder,int is,int ie,int ps,int pe) {
    	if(is>=ie) {
    		return true;
    	}
    	int root = posOrder[pe];
    	int indexOfIn = findx(inOrder, is, ie, root);
    	if(indexOfIn==-1) return  false;
    	int lis = is;
    	int lie = indexOfIn-1;
    	int ris = indexOfIn+1;
    	int rie = ie;
    	int lLen = lie-lis+1;
    	int lps = ps;
    	int lpe = ps+lLen-1;
    	int rps = lpe+1;
    	int rpe = pe-1;
    	for(int i=lis;i<=lie;i++) {
    		if(findx(posOrder, lps, lpe, inOrder[i])==-1) {
    			return false;
    		}
    	}
    	for(int i=ris;i<=rie;i++) {
    		if(findx(posOrder, rps, rpe, inOrder[i])==-1) {
    			return false;
    		}
    	}
    	return verify(posOrder, inOrder, lis, lie, lps, lpe)&&verify(posOrder, inOrder, ris, rie, rps, rpe);
    }
    public static int findx(int[] sequence,int start,int end,int x) {
    	for(int i=start;i<=end;i++) {
    		if(x==sequence[i])return i;
    	}
    	return -1;
    }
    public static void main(String[] args) {
		int[] i = {7,4,6,5};
		boolean flag = VerifySquenceOfBST(i);
		System.out.println(flag);
	}
}