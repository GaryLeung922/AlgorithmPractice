package cn.xiaojiaqi.sword2Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫环问题
 * @Author: liangjiaqi
 * @Date: 2020/6/25 11:18 AM
 */
public class JZ46 {
    public static void main(String[] args) {

    }

    /**
     * 解法一： 数学公式：
     * f(n,m)=(m%n+f(n-1,m))%n;
     * f(1,m)=0;
     * 当已知f(n-1,m)=x 时， 那么f(n,m)就等于m%n 再走x步
     * 时间复杂度O(n), 空间复杂度O(1)
     *
     * 由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。当我们知道了 f(n - 1, m) 对应的答案 x 之后，我们也就可以知道，
     * 长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m==0)return -1;

        int index = 0;
        for(int i=2;i<=n;i++){
            index = (index+m)%i;
        }
        return index;
    }
    public int LastRemaining_Solution2(int n, int m) {
        if (n == 0 || m == 0) return -1;

        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int remove = 0;
        while (list.size()>1){
            remove = (remove+m-1)%list.size();
            list.remove(remove);
        }
        return list.get(0);
    }
}

