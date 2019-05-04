package cn.xiaojiaqi.test;
public class Solution19 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        String pre1 = preSerialize(root1);
        String pre2 = preSerialize(root2);
        for(int i=0;i<pre1.length()-pre2.length();i++){
            if(pre1.charAt(i) == pre2.charAt(0)){
                int j=0;
                for(;j<pre2.length();j++){
                    if(pre1.charAt(i+j) != pre2.charAt(j)){
                        break;
                    }
                }
                if(j==pre2.length()){
                    return true;
                }
            }
        }
        return false;
    }
    public String preSerialize(TreeNode root){
        String pre="";
        if(root==null){
            return "#!";
        }else{
            pre+= preSerialize(root.left);
            pre+= preSerialize(root.right);
        }
        return pre;
    }
}