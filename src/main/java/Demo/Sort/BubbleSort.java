package Demo.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return arr;
        }
        int len=arr.length;

        for(int i=0;i<len;i++){
            boolean flag=true;
            for(int j=0;j<len-i-1;j++){
                if (arr[j+1]<arr[j]){
                    flag =false;
                    int tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
            //一趟下来是否发生位置交换
            if(flag){
                break;
            }
        }
        return arr;
    }
    //测试
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5,2, 0,10,6};
        System.out.println(Arrays.toString(arr));
        arr = bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
