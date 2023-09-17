package HashTable;

public class Continuous_sub_array {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {

            boolean result=false;
            if(nums.length<2)
                return false;
            Map<Integer,Integer> mp=new HashMap<>();
            mp.put(0,-1);
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum=sum+nums[i];
                if(!mp.containsKey(sum%k))
                    mp.put(sum%k,i);
                else if(mp.get(sum%k)<i-1)
                    return true;

            }
            return false;

        }
    }
}
