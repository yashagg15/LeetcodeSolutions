package sliding_window;

public class subarray_with_k_distinct_integer {
    class Solution {

        public int countsubarray(int k, int[] nums){

            if(k<=0)
                return 0;

            Map<Integer,Integer> map=new HashMap<>();
            int count=0;
            int j=0;

            //Find subarray atmost k distinct integer- Find subarray with atmost k-1 distinct integer
            //so, will have exactly k distinct integer

            for(int i=0;i<nums.length;i++){

                if(i!=0){
                    map.put(nums[i-1],map.get(nums[i-1])-1);
                    if(map.get(nums[i-1])==0)
                        map.remove(nums[i-1]);
                }

                while(j<nums.length){
                    map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                    if(map.size()<=k){
                        count=count+(j-i+1);
                    }else{
                        map.remove(nums[j]);
                        break;
                    }
                    j++;
                }

            }
            return count;

        }

        public int subarraysWithKDistinct(int[] nums, int k) {

            int result=countsubarray(k,nums)-countsubarray(k-1,nums);
            return result;


        }
    }
}
