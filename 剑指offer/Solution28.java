package cn.xiaojiaqi.test;
public class Solution28 {
    public static boolean isNumeric(char[] str) {
        
        if(str!=null&&str.length>0){
            boolean hasSign = false;
            boolean hasE = false;
            boolean hasDcm = false;
            boolean noNum = false;
            
            for(int i=0;i<str.length;i++){
                if(i==0){
                    hasSign = (str[i]=='+'||str[i]=='-')?true:false;
                    noNum = !hasSign&&(str[i]<='0'||str[i]>'9')?true:false;
                    if(noNum)return false;
                }else{
                    hasE = (str[i]=='e'||str[i]=='E')?true:false;
                    if(hasE)return isInteger(str,i+1,str.length-1,true);
                    hasDcm = str[i]=='.'?true:false;
                    if(hasDcm)return isInteger(str,i+1,str.length-1,false);
                    noNum = (str[i]<'0'||str[i]>'9')?true:false;
                    if(noNum)return false;
                }
            }
            return true;
            
        }
        return false;
    }
    public static boolean isInteger(char[] str,int start,int end,boolean isAfterE){
        if(start>end){
            return false;
        }else{
            boolean hasSign = false;
            boolean noNum = false;
            boolean hasE = false;
            for(int i=start;i<=end;i++){
                if(i==start){
                    if(isAfterE){
                        hasSign = (str[i]=='+'||str[i]=='-')?true:false;
                        noNum = !hasSign&&(str[i]<='0'||str[i]>'9')?true:false;
                        if(noNum)return false;
                    }else{
                        noNum = !hasSign&&(str[i]<'0'||str[i]>'9')?true:false;
                        if(noNum)return false;
                    } 
                }else{
                    if(isAfterE){
                        noNum = (str[i]<'0'||str[i]>'9')?true:false;
                        if(noNum)return false;
                    }else{
                        hasE = (str[i]=='e'||str[i]=='E')?true:false;
                        if(hasE)return isInteger(str,i+1,str.length-1,true);
                        noNum = (str[i]<'0'||str[i]>'9')?true:false;
                        if(noNum)return false;
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
		String strs = "-.123";
		char[] str = strs.toCharArray();
		boolean flag = isNumeric(str);
		System.out.println(flag);
	}
}