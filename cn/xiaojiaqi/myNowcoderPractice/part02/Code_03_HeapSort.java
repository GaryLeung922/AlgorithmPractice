package part02;

import java.util.Arrays;

public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		int len = arr.length;
		initHeap(arr);
		//System.out.println("---"+Arrays.toString(arr));
		while (len>0) {
			swap(arr, 0, len-1);
			heapify(arr, 0, --len);
		}
	}
	//只会往下沉！！！！
	//当index位置元素变小时（重点）,调整堆(建立在堆已经是大根堆的情况下)
	//这个heapify只会与子节点比较，不会和父节点比较。
	public static void heapify(int[] arr,int index,int size) {
		int left = 2*index+1;
		int right = left+1;
		while(left<size) {
			int large = arr[left]>arr[index]?left:index;
			if(right<size&&arr[right]>arr[large]) {
				large = right;
			}
			if(large==index)return;
			swap(arr, large, index);
			index = large;
			left = 2*large+1;
			right = left+1;
		}
//		if(right<size) {
//			int large = arr[left]>arr[right]?left:right;
//			large = arr[large]>arr[index]?large:index;
//			if(large!=index) {
//				swap(arr, large, index);
//				heapify(arr, large, size);
//			}
//		}else if(left<size) {
//			int large = arr[left]>arr[index]?left:index;
//			if(large!=index) {
//				swap(arr, large, index);
//				heapify(arr, large, size);
//			}
//		}
	}
	//往堆尾增加元素
	public static void heapInsert(int[] arr,int index) {
		int parent = (index-1)/2;
		while(parent>=0&&arr[index]>arr[parent]) {
			swap(arr, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}
	//初始化堆
	public static void initHeap(int[] arr) {
		for(int i=arr.length/2-1;i>=0;i--) {
			heapify(arr, i, arr.length);
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr= {0,5,4,2,3,1,0};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 5, 0, 10)[0];
			String arrstr = Arrays.toString(arr);
			heapSort(arr);
			String str1 = Arrays.toString(arr);
			Arrays.sort(arr);
			String str2 = Arrays.toString(arr);
			if(!str1.equals(str2)) {
				success  = false;
				System.out.println(arrstr);
				System.out.println(str1);
				System.out.println(str2);
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucking fucked!");
	}
	
}
