package Demo.DPSummary;

/**
 * 找零钱
 * 已知不同⾯值的钞票，求如 何⽤最少数量的钞票组成某个⾦额，求可 以使⽤的最少钞票数量。如果任
 * 意数量的已知⾯值钞票都⽆法组成该⾦额， 则返回-1。
 * 示例：
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Input: coins = [2], amount = 3
 * Output: -1
 */

public class dpQues6 {
    public int coinChange(int[] coins, int amount) {
        int len =coins.length;
        if (len==0||amount<0){
            return -1;
        }
        if (amount==0){
            return 0;
        }

        int[] dp=new int[amount+1];

        for (int i=0;i<=amount;i++){
            dp[i]=-1;
        }

        for (int i=0;i<len;i++){
            if (coins[i]==amount){
                return 1;
            }
            if(coins[i]<amount){
                dp[coins[i]]=1;
            }
        }

        for (int i=1;i<=amount;i++){
            for (int j=0;j<len;j++){
                if (i-coins[j]>=0&&dp[i-coins[j]]!=-1){
                    if (dp[i]==-1||dp[i]>dp[i-coins[j]]+1){
                        dp[i]=dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        int arr[] ={1,2,5};
        dpQues6 ques=new dpQues6();

        int result=ques.coinChange(arr,10);

        System.out.println(result);
    }
}
