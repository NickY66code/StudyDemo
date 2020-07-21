package Demo.Sort;

import java.util.Arrays;

public class SelectSort {

    public static int[] selectSort(int[] a){
        int len=a.length;


        for(int i=0;i<len-1;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            //交换
            int tmp=a[i];
            a[i]=a[min];
            a[min]=tmp;
        }
        return a;
    }

    //测试
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5,2, 0,10,6};
        System.out.println(Arrays.toString(arr));
        arr = selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
