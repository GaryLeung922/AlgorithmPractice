package advanced_part06;

public class Code_04_JosephusProblem {

	public static int LastRemaining_Solution(int n, int m) {
        if(n>0&&m>0){
            int i=1;
            int live=1;
            while(i<n){
                live = (live+m-1)%++i+1;
            }
            return live;
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5, 1));
	}

}
