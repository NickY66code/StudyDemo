package Demo.recursion;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class SelectMid {
    public static int getUpMedian(int[] arr1,int[] arr2){
        if (arr1==null||arr2==null){
            return -1;
        }

        //开始寻找
        return find(arr1,0,arr1.length-1,arr2,0,arr2.length-1);
    }

    public static int find(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2){
        int mid1=l1+(r1-l1)/2;
        int mid2=l2+(r2-l2)/2;

        //表示数组内只剩下一个数
        if (l1>=r1)
        {
            return Math.min(arr1[l1],arr2[l2]);
        }
        //如果offset为单数取0，双数取1
        int offset=(arr1.length&1)^1;

        if (arr1[mid1]<arr2[mid2]){
            return find(arr1,mid1+offset,r1,arr2,l2,mid2);
        }else if (arr1[mid1]>arr2[mid2]){
            return find(arr1,l1,mid1,arr2,l2+offset,r2);
        }else {
            return arr1[mid1];
        }

    }

    public static void main(String[] args){
        Scanner sc1 =new Scanner(System.in);
        System.out.println("请输入第一串数组,以空格隔开:");
        String s=sc1.nextLine();
        String[] str1=s.split(" ");
        int[] arr1=new int[str1.length];
        for (int i=0;i<str1.length;i++){
            arr1[i] =Integer.parseInt(str1[i]);
            System.out.print(arr1[i]);

        }
        System.out.println();
        Scanner sc2 =new Scanner(System.in);
        System.out.println("请输入第一串数组,以空格隔开:");
        String s2=sc2.nextLine();
        String[] str2=s2.split(" ");
        int[] arr2=new int[str1.length];
        for (int i=0;i<str1.length;i++){
            arr2[i] =Integer.parseInt(str2[i]);
            System.out.print(arr2[i]);
        }
        int result=SelectMid.getUpMedian(arr1,arr2);
        System.out.println(""+result);
    }
}
