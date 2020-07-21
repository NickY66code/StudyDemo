package Demo;

import java.util.*;

public class IOTest {

    public void IOPut() throws Exception {
        Scanner sc1 =new Scanner(System.in);
        System.out.println("请输入一段数字来表示该数组的长度");
        int v =sc1.nextInt();

        if (v<=0){
            throw new Exception("长度不能小于0");
        }

        System.out.println("请输入一段数组，以空格隔开");
        Scanner sc2 =new Scanner(System.in);
        int[] arr=new int[v];
        String str =sc2.nextLine();
        String a[] =str.split(" ");
         for (int i=0;i<arr.length;i++){
             arr[i]=Integer.parseInt(a[i]);
             System.out.println(arr[i]);
         }


        Scanner sc3 =new Scanner(System.in);
        String s=sc3.nextLine();
        String[] as = s.split(",");
        for (int i=0;i<as.length;i++){
            System.out.println("这串字符的为"+as[i]);
        }


    }


    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        String a=sc.nextLine();

        Character[] ch=new Character[a.length()];
        for (int i=0;i<a.length();i++){
            ch[i] =a.charAt(i);
            System.out.println(ch[i]);
        }

        IOTest io=new IOTest();
        io.IOPut();
    }

}
