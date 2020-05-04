package part05;

import java.util.HashMap;
/**
 * 
设计RandomPool结构
【题目】 设计一种结构，在该结构中有如下三个功能：
insert(key)：将某个key加入到该结构，做到不重复加入。
delete(key)：将原本在结构中的某个key移除。 getRandom()：
等概率随机返回结构中的任何一个key。
【要求】 Insert、delete和getRandom方法的时间复杂度都是
O(1)
 * @author Narut0
 *
 */
public class Code_01_RandomPool {
	
	public static class RandomPool{
		private HashMap<String, Integer> hm = null;
		private HashMap<Integer, String> help = null;
		private int size=0;
		public RandomPool() {
			hm = new HashMap<>();
			help = new HashMap<>();
		}
		public void insert(String key) {
			size++;
			hm.put(key, size);
			help.put(size, key);
			
		}
		public void delete(String key) {
			int id = hm.get(key);
			hm.put(help.get(this.size), id);
			hm.remove(key);
			help.put(id, help.get(this.size));
			size--;
			
		}
		public String getRandom() {
			return help.get((int)Math.ceil(Math.random()*this.size));
		}
		
	}
	public static void main(String[] args) {
		RandomPool rp = new RandomPool();
		rp.insert("leng1");
		rp.insert("leng2");
		rp.insert("leng3");
		rp.insert("leng4");
		
		int c1=0;
		int c2=0;
		int c3=0;
		int c4=0;
		int cl=0;
		String cll;
		rp.delete("leng1");
		for(int i=0;i<999999;i++) {
			String str = rp.getRandom();
			if("leng1".equals(str)) {
				c1++;
			}else if ("leng2".equals(str)) {
				c2++;
			}else if ("leng3".equals(str)) {
				c3++;
			}else if ("leng4".equals(str)) {
				c4++;
			}else {
				cl++;
				cll = str;
			}
		}
		System.out.println("c1  c2  c3  c4");
		System.out.println(c1+" "+c2+" "+c3+" "+c4);
		System.out.println(c1+c2+c3+c4);
		System.out.println(cl);
		
	}
}
