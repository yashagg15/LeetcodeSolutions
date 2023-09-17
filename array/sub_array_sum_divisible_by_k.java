package array;

public class sub_array_sum_divisible_by_k {

    class Solution {
        public int subarraysDivByK(int[] nums, int k) {

            Map<Integer,Integer> mp=new HashMap<>();
            mp.put(0,1);
            int sum=0;
            int count=0;
            for(int i=0;i<nums.length;i++){
                int t=nums[i];
                if(t<0){
                    int div=Math.abs(t)/k;
                    t=t+div*k+k;
                }
                sum=sum+t;
                if(mp.containsKey(sum%k)){
                    count=count+mp.get(sum%k);
                    mp.put(sum%k,mp.get(sum%k)+1);
                }
                else{
                    mp.put(sum%k,1);
                }

            }
            return count;

        }
    }
}
