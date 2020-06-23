package cn.xiaojiaqi.sword2Offer;

/**
 * 树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author: liangjiaqi
 * @Date: 2020/6/21 10:08 PM
 */
public class JZ17 {
    public static void main(String[] args) {

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)return false;
        String str1 = serialPre(root1);
        String str2 = serialPre(root2);
        while (str2.substring(str2.length()-2,str2.length()).equals("#!")){
            str2 = str2.substring(0,str2.length()-2);
        }
        return str1.contains(str2);

    }
    public String serialPre(TreeNode root){
        if(root==null)return "#!";
        return root.val+"!"+serialPre(root.left)+serialPre(root.right);
    }
}
