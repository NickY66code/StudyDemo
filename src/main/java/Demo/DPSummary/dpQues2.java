package Demo.DPSummary;

public class dpQues2 {
    public static int uniquePaths(int[][] arr){
        int n =arr.length;
        int m=arr[0].length;

        if (n<=0||m<=0){
            return 0;
        }

        //初始化
        int[][] dp=new int[n][m];

        //给dp[0][0]初始值
        dp[0][0]=arr[0][0];

        //初始化最左边的列
        for (int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        //初始化最上边的行
        for (int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+arr[0][i];
        }

        //推导出 dp[m-1][n-1]
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }

        //返回值
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {

        int[][] arr={{2,3,4,5},{1,3,2,4},{1,3,5,3},{1,2,3,4}};
        int result=dpQues2.uniquePaths(arr);
        System.out.println(result);
    }
}
