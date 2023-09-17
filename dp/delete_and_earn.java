package dp;

public class delete_and_earn {
    class Solution {
        public int deleteAndEarn(int[] nums) {

            Map<Integer,Integer> mp=new TreeMap<>();
            if(nums.length==0)
                return 0;
            if(nums.length==1)
                return nums[0];
            if(nums.length==2){
                if((nums[0]+1)==nums[1] || (nums[1]+1)==nums[0])
                    return Math.max(nums[0],nums[1]);
                else
                    return nums[0]+nums[1];
            }

            int max=0;
            for(int i=0;i<nums.length;i++){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+nums[i]);
                if(nums[i]>max)
                    max=nums[i];
            }

            int res=0;
            int dp[]=new int[max+1];
            dp[1]=mp.getOrDefault(1,0);
            System.out.println(max);
            for(int i=2;i<dp.length;i++){

                int prev=dp[i-2];
                int current=mp.getOrDefault(i,0);
                dp[i]=Math.max(dp[i-1],prev+current);

            }
            return dp[max];


        }
    }
}
