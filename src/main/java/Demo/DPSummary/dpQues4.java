package Demo.DPSummary;

import org.w3c.dom.ls.LSOutput;

/***
 * 在⼀条直线上，有n个房屋，每个房屋中有数量不等的财宝，有⼀个盗 贼希望从房屋中盗取财宝，由于
 * 房屋中有报警器，如果同时从相邻的两个房屋中盗取财宝就会触发报警器。问在不触发报警器的前提
 * 下，最多可获取多少财宝？例如 [5，2，6，3，1，7]，则选择5，6，7
 */
public class dpQues4 {
    public int solution(int[] arr){
        if (arr.length==0){
            return 0;
        }

        int dp[]=new int[arr.length];

        dp[0]=arr[0];

        // 每次做数组判定时都需要做数组边界判定，防⽌越界
        if(arr.length < 2)
            return arr[0];
        dp[1]=(arr[0]>arr[1])? arr[0]:arr[1];

        for (int i=2;i<arr.length;i++){
            dp[i]=(dp[i-2]+arr[i])>dp[i-1] ?dp[i-2]+arr[i]:dp[i-1];
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr={1,2,4,6,8,2,5,5};

        dpQues4 ques=new dpQues4();

        int result=ques.solution(arr);

        System.out.println(result);
    }
}
