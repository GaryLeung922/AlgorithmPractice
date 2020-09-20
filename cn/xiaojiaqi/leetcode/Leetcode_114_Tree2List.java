package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

//二叉树转化为先序的链表
//考虑如果是中序呢？如果是后序呢？
//无非就是想让你把左子树插入到右子树之上
public class Leetcode_114_Tree2List {
//     Stack<TreeNode> help = new Stack<>();
//     TreeNode pre=null;
//     public void flatten(TreeNode root) {
//         preOrder_linked(root);
//         TreeNode pre = null;
//         TreeNode p;
//         while(!help.isEmpty()){
//             p = help.pop();
//             p.right = pre;
//             p.left = null;
//             pre = p;
//         }
//     }
//     public void preOrder_linked2(TreeNode root){
//         Stack<TreeNode> stack = new Stack<>();
//         Stack<TreeNode> help = new Stack<>();
//         TreeNode p = root;
//         while(!stack.isEmpty()||p!=null){
//             if(p!=null){
//                 help.push(p);
//                 stack.push(p);
//                 p = p.left;
//             }else{
//                 p = stack.pop();
//                 p = p.right;
//             }
//         }
//         TreeNode pre = null;
//         while(!help.isEmpty()){
//             p = help.pop();
//             p.right = pre;
//             p.left = null;
//             pre = p;
//         }
//     }
//     public void preOrder_linked(TreeNode root){
//         if(root!=null){
//             help.push(root);
//             preOrder_linked(root.left);
//             preOrder_linked(root.right);
//         }  
//     }
    
    //1902   仿Morris     Amazing!!!!   不要一上来就想着套用这个那个，首先你要搞清楚他要你做的是啥。搞清楚做的是啥之后就很好理解了。   无非就是想让你把左子树插入到右子树之上
    // 非迭代
    // public void flatten(TreeNode root) {
    //     while(root!=null){
    //         TreeNode mr=root.left;
    //         if(mr!=null){
    //             while(mr.right!=null){
    //                 mr = mr.right;
    //             }
    //             mr.right = root.right;
    //             root.right = root.left;
    //             root.left = null;
    //         }
    //         root = root.right;
    //     }
    // }
    
    //先序展开 递归
    // https://www.cnblogs.com/grandyang/p/4293853.html
//    public void flatten(TreeNode root) {
//        if(root==null)return;
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        flatten(left);
//        flatten(right);
//        
//        TreeNode mr = left;
//        if(mr!=null){//如果左子树不为空,找到左子树最右的结点
//            while(mr.right!=null){
//                mr = mr.right;
//            }
//            //开始连接
//            mr.right = root.right;
//            root.right = left;
//            root.left = null;
//        }
//    }
	
	//先序展开 迭代
//	public static void flatten(TreeNode root) {
//		if(root==null) return;
//		TreeNode prv = root;
//		//Stack<TreeNode> s = new Stack<>();
//		//s.push(root);
//		while(prv!=null) {
//			TreeNode t = prv;
//			if(t.left!=null) {
//				TreeNode r = t.left;
//				while (r.right!=null) r = r.right;
//				r.right = t.right;
//				t.right = t.left;
//				t.left = null;
//			}
//			if(t.right!=null)prv = t.right;
//			else prv=null;
//		}
//		
//	}
	
    //中序展开 递归
//    public static TreeNode  flatten(TreeNode root) {
//    	if(root==null)return root;
//    	TreeNode left = root.left;
//    	TreeNode right = root.right;
//    	
//    	if(left!=null) left = flatten(left);
//    	if(right!=null)right = flatten(right);
//    	
//    	if(left!=null) {
//    		TreeNode mr = left;
//    		while(mr.right!=null) {
//    			mr = mr.right;
//    		}
//    		mr.right = root;
//    		root.left = null;
//    		root.right = right;
//    		return left;
//    	}
//    	root.right = right;
//    	return root;
//    }
	//中序展开 非递归
	public static TreeNode flatten(TreeNode root) {
		TreeNode pre = null;
		while(root!=null) {
			TreeNode mr = root.left;
			if(mr!=null) {
				while(mr.right!=null&&mr.right!=root) mr = mr.right;
				if(mr.right==null) {
					mr.right = root;
					root = root.left;
				}else {
					//mr.right = null;
					root.left = pre;
					if(pre!=null)pre.right = root;
					pre = root;
					root = root.right;
				}
			}else {
				root.left = pre;
				if(pre!=null)pre.right = root;
				
				pre = root;
				root = root.right;
			}
		}
		while (pre.left!=null) {
			pre = pre.left;
		}
		return pre;
	}
	
	
	//中序展开 双向链表  递归
//	public static TreeNode flatten(TreeNode root) {
//		if(root==null)return null;
//	    TreeNode right = flatten(root.right);
//	    TreeNode left = flatten(root.left);
//	    
//	    if(left!=null){
//	        TreeNode p = left;
//	        while(p.right!=null)p = p.right;
//	        p.right = root;
//	        root.left = p;
//	        root.right = right;
//	        if(right!=null)right.left = root;
//	        return left;
//	    }
//	    root.right = right;
//	    if(right!=null)right.left = root;
//	    return root;
//	}
	
    public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);
		
		TreeNode res = flatten(root);
		
	}
    
}