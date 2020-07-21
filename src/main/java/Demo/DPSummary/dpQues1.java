package Demo.DPSummary;

public class dpQues1 {
    public static int uniquePaths(int n,int m){
    if (n<=0||m<=0){
        return 0;
    }

    int[][] dp=new int[n][m];

    for (int i=0;i<n;i++){
        dp[i][0]=1;
    }
    for (int i=0;i<n;i++){
        dp[0][i]=1;
    }

    for (int i=1;i<n;i++){
        for (int j=1;j<m;j++){
            dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
    }

    return dp[n-1][m-1];
}

    public static void main(String[] args) {
        int result=dpQues1.uniquePaths(5,6);
        System.out.println(result);
    }
}
