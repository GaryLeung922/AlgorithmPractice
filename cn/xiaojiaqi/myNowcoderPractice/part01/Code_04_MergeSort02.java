package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

public class Code_04_MergeSort02 extends AbstractSort{

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr, int L, int R) {
        if(L >= R){
            return;
        }
        int mid = L + ((R-L)>>1);
        mergeSort(arr, L , mid);
        mergeSort(arr,mid+1, R);
        merge(arr, L, R);
    }

    private void merge(int[] arr, int l, int r) {
        int[] help = new int[r-l+1];
        int mid = l + ((r-l)>>1);
        int a = l;
        int b = mid+1;
        int h = 0;
        while(a<=mid && b<= r){
            if(arr[a]<= arr[b]){
                help[h++] = arr[a++];
            }else {
                help[h++] = arr[b++];
            }
        }
        while(a<=mid){
            help[h++] = arr[a++];
        }
        while (b<=r){
            help[h++] = arr[b++];
        }

        for(int i=0;i<help.length;i++){
            arr[l++] = help[i];
        }
    }

    public static void main(String[] args) {
        Code_04_MergeSort02 sort02 = new Code_04_MergeSort02();
        int[] ints = TestUtil.generateArr(1, 5, 0, 20)[0];
        System.out.println(Arrays.toString(ints));
        sort02.sort(ints);
        System.out.println(Arrays.toString(ints));

        sort02.compareResult(9999);
    }
}
