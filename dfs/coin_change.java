package dfs;

public class coin_change {

    class Solution {

        public int change(int[] coins,int amount,int res,int dp[]){

            if(amount==0)
                return 0;

            if(amount<0)
                return -1;

            if(dp[amount]!=0)
                return dp[amount];

            int num=Integer.MAX_VALUE;
            for(int i=0;i<coins.length;i++){
                int temp=change(coins,amount-coins[i],res+1,dp);
                if(temp>=0 && temp<num){
                    num=temp+1;
                }

            }
            dp[amount]=num;
            return num;


        }


        public int coinChange(int[] coins, int amount) {

            int dp[]=new int[amount+1];
            int res=change(coins,amount,0,dp);
            return res==Integer.MAX_VALUE?-1:res;

        }
    }
}
