package Demo.GreedyAl;


import java.util.Scanner;

    public class Main{
        public int result(int x,int f,int d,int p){
            if(d==0){
                return 0;
            }
            //理想最大生活天数
            int max =d/x;
            if(f==max){
                return max;
            }
            int result=1;

            while(d>0){
                if(f>0){
                    d=d-x;
                    f--;
                    if(d<x){
                        break;
                    }
                }else{
                    d=d-x-p;
                    if(d<x+p){
                        break;
                    }
                }
                result++;
            }
            return result;
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            //System.out.println("请输入一段整数x,f,d,p(以空格隔开)");
            String str=sc.nextLine();
            String[] arr=str.split(" ");
            int[] arrs=new int[arr.length];
            for(int i=0;i<arr.length;i++){
                arrs[i]=Integer.parseInt(arr[i]);
            }
            int x,f,d,p;
            x=arrs[0];
            f=arrs[1];
            d=arrs[2];
            p=arrs[3];
            Main ques=new Main();
            int res= ques.result(x,f,d,p);
            System.out.println(res);
        }
    }

