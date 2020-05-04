package cn.xiaojiaqi.sword2Offer;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {
		boolean success = true;
//		for(int i=0;i<Integer.MAX_VALUE;i++) {
//			byte[] b = int2byte2(i);
//			int ans = byte2int2(b);
//			if(ans!=i) {
//				success = false;
//				System.out.println("i = "+i);
//				System.out.println(Arrays.toString(b));
//				break;
//			}
//		}
		System.out.println(success ? "Niced" : "Fucking Fucked!");
		
		int d = 128;
		byte[] e = int2byte2(d);
		byte c = (byte)d;
		System.out.println(c);
		System.out.println(Arrays.toString(e));
		System.out.println((byte)((int)c));
	}
	public static int byte2int(byte[] b) {
		return b[3]&0xFF |
				(b[2]&0xFF) <<8 |
				(b[1]&0xFF) <<16 |
				(b[0]&0xFF) << 24;
	}
	public static byte[] int2byte(int a) {
		return new byte[] {
				(byte) ((a>>24)&0xFF),
				(byte) ((a>>16)&0xFF),
				(byte) ((a>>8)&0xFF),
				(byte) ((a)&0xFF)};
	}
	public static int byte2int2(byte[] b) {
		return b[3]&0xFF |
				(b[2]&0xFF) <<8 |
				(b[1]&0xFF) <<16 |
				(b[0]&0xFF) << 24;
	}
	public static byte[] int2byte2(int a) {
		return new byte[] {
				(byte) ((a>>24)),
				(byte) ((a>>16)),
				(byte) ((a>>8)),
				(byte) ((a))};
	}
	
	

}
