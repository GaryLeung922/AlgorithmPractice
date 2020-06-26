package cn.xiaojiaqi.sword2Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 二叉搜索树的后序遍历序列
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @Author: liangjiaqi
 * @Date: 2020/6/25 9:50 AM
 */
public class JZ23 {
    public static void main(String[] args) {

    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length==0)return false;

        int[] in = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(in);
        return fromInAndPost(in, sequence, 0, in.length-1, 0, in.length-1);

    }

    /** 解法一：
     * 按照根据后序和中序重建整颗二叉树。 然后在重建的过程中查看是否满足条件
     *
     * 时间复杂度O(nlogn) 空间复杂度 O(n)
     * @param in
     * @param post
     * @param il
     * @param ir
     * @param pl
     * @param pr
     * @return
     */
    public boolean fromInAndPost(int[] in,int[] post, int il, int ir, int pl, int pr){
        if(ir-il==0){
            // 1. 只剩最后一个节点，此时in和post剩下的数必然相等
            return in[ir]==post[pr] ? true:false;
        }else if(ir-il < 0 ){
            return true;
        }
        TreeNode node = new TreeNode(Integer.valueOf(post[pr]));
        int index = il;
        while (index<=ir){
            if(in[index]!=post[pr]){
                index++;
            }else {
                break;
            }
        }
        if(index>ir){
            // 2.如果在in的序列中，没有找到，则一定有问题
            return false;
        }
        // 3.递归左右子树
        return fromInAndPost(in, post, il, index-1,pl,pl+(index-il)-1) && fromInAndPost(in,post,index+1,ir,pr-(ir-index),pr-1);

    }


    /**
     * 解法二：上下限约束法
     *
     * 具体来说，二叉搜索树的关键特征是：对于任意一棵子树，均有“左子树<根节点<右子树”，
     * 因此，它的根节点约束了它左右子树的取值范围，二叉搜索树的根root是它左子树值的上限（max），同时是它右子树值的下限（min）。
     * 如果我们从根节点出发往下走，那么高层祖辈节点序列就会不停地对低层未遍历节点形成一个上下限约束，只要低层节点没有违背这个约束，那么它就是合法的，否则，序列就是不合法的。
     *
     * 时间复杂度O(n) 空间复杂度 O(n)
     * @param seq
     * @return
     */
    public boolean helpVerify(int[] seq){
        if(seq==null || seq.length <=0)return false;

        // roots栈里面依次存放各层祖辈节点的值
        // 事先放入一个值以避免对空栈进行判断
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        int max = Integer.MAX_VALUE;
        for(int i=seq.length-1;i>=0;i--){
            // 当节点超过max约束时，它必定不是二叉搜索树
            if(seq[i]>=max)return false;

            // 如果节点小于roots的栈顶，说明该节点是某个祖辈的左孩子
            // 不断出栈，直到找出该祖辈，同时，该祖辈也提供了新的max约束
            while (seq[i]<stack.peek()){
                max = stack.pop();
            }
            // 该节点成了新一代的祖辈节点，为后续节点判断自己的位置提供依据
            stack.push(seq[i]);
        }
        return true;
    }


}
