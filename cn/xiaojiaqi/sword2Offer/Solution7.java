package cn.xiaojiaqi.sword2Offer;

public class Solution7 {
	public String ReverseSentence(String str) {
        if(str!=null&&str.length()>0){
            String[] strArr = str.split(" ");
            if(strArr.length==0){
                return new String(" ");
            }
            StringBuilder newStr = new StringBuilder();
            for(int i=strArr.length-1;i>=0;i--){
                
                newStr.append(strArr[i]+(i==0?"":" "));
            }
            return newStr.toString();
        }
        return new String("");
    }
    public static void main(String[] args) {
		String str = "student. a am I";
		Solution7 solution7 = new Solution7();
		System.out.print(solution7.ReverseSentence(str));
		System.out.println("+++++");
	}
}