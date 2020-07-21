package Demo.DPSummary;

public class dpQues3 {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        int[][] dp=new int[n1+1][n2+1];

        //初始化列的值
        for (int i =1;i<=n1;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        //初始化行的值
        for (int i =1;i<=n2;i++){
            dp[0][i]=dp[0][i]+1;
        }

        //通过公式推导dp[n1][n2]
        for (int i=1;i<=n1;i++){
            for (int j=1;j<=n2;j++){
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String word1="inters";
        String word2="inter";

        dpQues3 ques=new dpQues3();
        int result=ques.minDistance(word1,word2);
        System.out.println(result);
    }
}
