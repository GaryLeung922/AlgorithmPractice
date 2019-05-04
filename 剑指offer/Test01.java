package cn.xiaojiaqi.test;

public class Test01 {

	 public static String replaceSpace(StringBuffer str) {
	    	if(str!=null&&str.length()>1) {
	    		for(int i=0;i<str.length();i++) {
	    			if(str.charAt(i)==' ') {
	    				str.replace(i, i+1, "%20");
	    			}
	    		}
	    		return str.toString();
	    	}
	    	return "";
	 }
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(str));
		System.out.println((int)'1');
	}
	
}
