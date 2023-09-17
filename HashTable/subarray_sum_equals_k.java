package HashTable;

public class subarray_sum_equals_k {
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int result=0;
            Map<Integer,Integer> mp=new HashMap<>();
            mp.put(0,1);
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum=sum+nums[i];
                if(mp.containsKey(sum-k)){
                    result=result+mp.get(sum-k);
                }
                if(!mp.containsKey(sum))
                    mp.put(sum,1);
                else
                    mp.put(sum,mp.get(sum)+1);
            }
            return result;

        }
    }
}
