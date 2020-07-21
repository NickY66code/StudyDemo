package Demo.Sort;

import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int arr[]){
        if(arr==null||arr.length<2){
            return arr;
        }

        int len=arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for(int h=len/2;h>0;h/=2){
            //对各个局部分组进行插入排序
            for(int i=h;i<len;i++){
                // 将arr[i] 插入到所在分组的正确位置上
                insertI(arr, h, i);
            }
        }
            return arr;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上
     * arr[i]] 所在的分组为 ... arr[i-2*h],arr[i-h], arr[i+h]
     */
    private static void insertI(int[] arr, int h, int i) {
        int temp=arr[i];
        int k;
        for(k=i-h;k>=0&&temp<arr[k];k-=h){
            arr[k+h]=arr[k];
        }
        arr[k+h]=temp;
    }

    //测试
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5,2, 0,10,6,7,12,4,8,9};
        System.out.println(Arrays.toString(arr));
        arr = shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
