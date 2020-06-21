package cn.xiaojiaqi.sword2Offer;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 * @Author: Gary Leung
 * @Date: 6/17/20 11:30 PM
 */
public class JZ61 {
    public static void main(String[] args) {
        JZ61 jz61 = new JZ61();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(11);

        String s = jz61.Serialize(root);
        System.out.println(s);
        System.out.println(Arrays.toString(s.split("!")));
        TreeNode root2 = jz61.Deserialize(s);
        String s2 = jz61.Serialize(root2);
        System.out.println(s2);

//        TreeNode treeNode = jz61.Deserialize(s);
//
//        SerAndDeSer.printTree(treeNode);

    }

    String Serialize(TreeNode root) {
        if(root == null)return "#!";
        return String.valueOf(root.val)+"!"+Serialize(root.left)+Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        if(str==null || str.equals(""))return null;
        Queue<String> queue = new LinkedList<>();
        String[] strs = str.split("!");
        for(String string: strs){
            queue.offer(string);
        }
        return Deserialize(queue);
    }
    TreeNode Deserialize(Queue<String> strs){
        String str = strs.poll();
        TreeNode root = "#".equals(str) ? null : new TreeNode(Integer.valueOf(str));
        if(root==null) return null;
        root.left = Deserialize(strs);
        root.right = Deserialize(strs);
        return root;
    }
}
