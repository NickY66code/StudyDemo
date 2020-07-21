package Demo.Sort;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        if(arr==null||arr.length<2){
            return arr;
        }
        int len=arr.length;

        for(int i=1;i<len;i++){
            int tmp=arr[i];
            int k=i-1;
            while(k>=0&&arr[k]>tmp){
                k--;
            }

            for (int j=i;j>k+1;j--){
                arr[j]=arr[j-1];
            }
            arr[k+1]=tmp;
        }

        return arr;
    }

    //测试
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5,2, 0,10,6};
        System.out.println(Arrays.toString(arr));
        arr = insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
