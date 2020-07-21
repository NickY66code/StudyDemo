package Demo.DPSummary;

/**
 * 原问题
 * 给定⼀个数组，求这个数组的连续⼦数组中，最⼤的那⼀段的和。 如数组[-2,1,-3,4,-1,2,1,-5,4] 的⼦段
 * 为：[-2,1]、[1,-3,4,-1]、[4,-1,2,1]、...、[-2,1,-3,4,-1,2,1,-5,4]，和最⼤的是[4,1,2,1]，为6。
 *
 * 示例：
 * Input: int [] nums = [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class dpQues5 {
    public int Maximum(int[] arr){
        if(arr.length<=0){
            return 0;
        }

        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        int max=dp[0];

        for (int i=1;i<arr.length;i++){
            dp[i]=(dp[i-1]+arr[i])>arr[i]? dp[i-1]+arr[i]:arr[i];

            if (max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int arr[] ={-1,2,-4,2,4,-3,2,-2};
        dpQues5 ques=new dpQues5();

        int result=ques.Maximum(arr);

        System.out.println(result);
    }
}
