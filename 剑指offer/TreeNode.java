package cn.xiaojiaqi.test;
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    public static int m() {
    	int i=0;
    	try {
			return i;
		} finally {
			
			i = 10;
			System.out.println("i = "+i);
		}
    }
    public static void main(String[] args) {
		System.out.println(m());
	}
}