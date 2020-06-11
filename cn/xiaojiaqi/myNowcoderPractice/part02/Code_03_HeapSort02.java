package cn.xiaojiaqi.myNowcoderPractice.part02;

import cn.xiaojiaqi.common.TestUtil;
import cn.xiaojiaqi.common.TreeNode;
import cn.xiaojiaqi.myNowcoderPractice.part01.AbstractSort;

import java.util.Arrays;

/**
 * @Author: Gary Leung
 * @Date: 5/12/20 10:40 PM
 */
public class Code_03_HeapSort02 extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        initHeap(arr);
        int heapsize = arr.length;
        while (heapsize > 0){
            swap(arr, 0, --heapsize);
            heapify(arr,0, heapsize);
        }
    }

    /**
     *  初始化堆：从最后一个非叶子结点开始，从右往左，从下往上。
     * @param arr
     */
    public void initHeap(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i=arr.length/2 -1;i>=0;i--){
            heapify(arr, i, arr.length);
        }
    }

    public void heapInsert(int[] arr, int i){
        if(arr == null || arr.length < 2 || i < 0 || i > arr.length -1)
            return;
        // 浮到顶
        while(true){
            int father = (i-1)/2;
            if(father == i || arr[(i-1)/2] >= arr[i]){
                return;
            }else {
                swap(arr, i, father);
                i = father;
            }
        }
    }

    public void heapify(int[] arr, int i, int heapsize){
        if(arr == null || arr.length < 2 || heapsize <= 0 || heapsize > arr.length || i < 0 || i > heapsize -1)
            return;
        // 沉到底
        while(i<heapsize){
            int largest = (i*2+2) < heapsize && arr[(i*2+2)] > arr[(i*2+1)] && arr[i*2+2] > arr[i] ?
                    (i*2+2) :
                    i*2+1 < heapsize && arr[i*2+1] > arr[i] ? i*2+1 : i;
            if(largest == i)
                return;
            swap(arr, i, largest);
            i = largest;
        }
    }

    public static void main(String[] args) {
        Code_03_HeapSort02 sort02 = new Code_03_HeapSort02();
//        boolean flag = true;
//        for(int i=0;i<5000000;i++){
//            int[] ints = TestUtil.generateArr(1,10,-10,10)[0];
//            int[] ints1 = Arrays.copyOf(ints, ints.length);
//
//            sort02.sort(ints);
//            Arrays.parallelSort(ints1);
//            boolean result = Arrays.equals(ints, ints1);
//            if(!result) {
//                System.out.println(Arrays.toString(ints));
//                System.out.println(Arrays.toString(ints1));
//                flag = false;
//                break;
//            }
//        }
        sort02.compareResult(9999);

//        int[] ints = TestUtil.generateArr(5);
//        System.out.println(Arrays.toString(ints));
//        sort02.sort(ints);
//        System.out.println(Arrays.toString(ints));

    }
}
