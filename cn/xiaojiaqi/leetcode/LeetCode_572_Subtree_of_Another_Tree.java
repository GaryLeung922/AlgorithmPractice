package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode_572_Subtree_of_Another_Tree {
    // 方法1：遍历验证子树
    
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     return preOrder(s,t);
    // }
    // public boolean preOrder(TreeNode s,TreeNode t){
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode p = s;
    //     while(p!=null||!stack.isEmpty()){
    //         if(p!=null){
    //             if(p.val==t.val){
    //                 if(equalTree(p,t))return true;
    //             }
    //             stack.push(p);
    //             p = p.left;
    //         }else{
    //             p = stack.pop();
    //             p = p.right;
    //         }
    //     }
    //     return false;
    // }
    // public boolean equalTree(TreeNode s,TreeNode t){
    //     if(s==null&&t==null)return true;
    //     if(s!=null&&t!=null&&s.val==t.val)return equalTree(s.left,t.left)&&equalTree(s.right,t.right);
    //     return false;
    // }
    
    //方法2：通过序列化来验证子树
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sPre= new StringBuilder();
        StringBuilder tPre= new StringBuilder(); 
        genPre(s,sPre);
        genPre(t,tPre);
        
        int res = sPre.toString().indexOf(tPre.toString());
        if(res==-1)return false;  
        if(res==0)return true;
        return sPre.toString().charAt(res-1)=='!';//[12] , [2]
        
    }
    public void genPre(TreeNode s,StringBuilder sPre){
        if(s==null){
            sPre.append("#!");
        }else{
            sPre.append(s.val+"!");
            genPre(s.left,sPre);
            genPre(s.right,sPre);
        }
    }
    
    
}