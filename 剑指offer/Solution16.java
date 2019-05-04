package cn.xiaojiaqi.test;

import java.util.HashMap;
import java.util.TreeMap;

public class Solution16 {
    private TreeMap<Integer,Character> tmap = new TreeMap<>();
    private HashMap<Character,Integer> hmap = new HashMap<>();
    private int comp = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(hmap.containsKey(ch)){
            int tkey = hmap.get(ch);
            if(tmap.containsKey(tkey)){
                tmap.remove(tkey);
            }
        }else{
            hmap.put(ch,comp);
            tmap.put(comp,ch);
            comp++;
        }
        
        
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return tmap.isEmpty()? '#': tmap.get(tmap.ceilingKey(-1));
    }
    public static void main(String[] args) {
		Solution16 solution16 = new Solution16();
		String string = "google";
		for(int i=0;i<string.length();i++) {
			solution16.Insert(string.charAt(i));
			char ch = solution16.FirstAppearingOnce();
			System.out.println(ch);
		}
	}
}