package cn.xiaojiaqi.leetcode;

import java.util.Stack;

public class LeetCode_394_Decode_String {

    public static String decodeString(String s) {
        int begin = 0;
        int intIndex = 0;
        StringBuilder result = new StringBuilder();
        while(begin<s.length()) {
        	
        	if(begin<s.length()) {
            	intIndex = begin;
            	while(intIndex<s.length()&&(s.charAt(intIndex)<'0'||s.charAt(intIndex)>'9')) {
        			intIndex++;
        		}
            }
        	result.append(s.substring(begin, intIndex));
        	begin = s.indexOf("[",begin);
        	if(begin==-1) {
//        		int end  = s.lastIndexOf("]");
//              result.append(s.substring(end+1));
                break;
        	}
        	String[] next =  decodeString(s,begin+1);
            int k = begin!=0 ? Integer.valueOf(s.substring(intIndex,begin)) : 0;
            
            for(int i=0;i<k;i++){
                result.append(next[0]);
            }
            
            begin = Integer.valueOf(next[1]);
            
        }
        
        return result.toString();
    }
    public static String[] decodeString(String s,int begin){
    	
    	
		StringBuilder apn = new StringBuilder();
		while(begin<s.length()) {
			int close = s.indexOf("]",begin);
	    	int open = s.indexOf("[",begin);
	    	if(open==-1||open>close) {//若没有[或[在]后面,说明到最近的]为止,可以直接返回(不需要递归下去)
	    		String str = s.substring(begin,close);
	    		begin = close+1;
	    		apn.append(str);
	    		break;
	    	}else {
				int i = 0;
	    		while(s.charAt(begin+i)<'0'||s.charAt(begin+i)>'9') {
	    			i++;
	    		}
	    		String str = s.substring(begin,begin+i);//求[后面,数字前面的子串
	    		apn.append(str);
	    		int k = Integer.valueOf(s.substring(begin+i,open));
	    		String[] next = decodeString(s,open+1);
	    		
	    		for(int j=0;j<k;j++) {
	    			apn.append(next[0]);
	    		}
	    		begin = Integer.valueOf(next[1]);
	    	}
		}
		return new String[] {apn.toString(),begin+""};	
    }
    public static String decodeStringByStack(String s) {
    	if(s==null||s.length()==0)return "";
    	
    	StringBuilder result = new StringBuilder();
    	Stack<String> stack = new Stack<>();
    	StringBuilder tmpstr = new StringBuilder();
    	StringBuilder num = new StringBuilder();
    	
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)!=']') {
    			stack.push(s.charAt(i)+"");
    		}else {
    			while(!"[".equals(stack.peek())) {
    				tmpstr.insert(0,stack.pop());
    			}
    			stack.pop();//弹出 [ 
    			while(!stack.isEmpty()&&stack.peek().length()==1&&stack.peek().toCharArray()[0]>='0'&&stack.peek().toCharArray()[0]<='9') {
    				num.insert(0,stack.pop());
    			}
    			int k = Integer.valueOf(num.toString());
    			num.delete(0, num.length());
    			String str = tmpstr.toString();
    			tmpstr.delete(0, tmpstr.length());
    			for(int j=0;j<k;j++) {
    				stack.push(str);
    			}
    		}
    	}
    	while(!stack.isEmpty()) {
    		result.insert(0, stack.pop());
    	}
    	return result.toString();
    }
    public static void main(String[] args) {
		String s = "3[a]2[bc]";
		String str = decodeString(s);
		System.out.println(str);
		//System.out.println('a'+"");
		
		String str2 = decodeStringByStack(s);
		System.out.println(str2);
		
	}
}