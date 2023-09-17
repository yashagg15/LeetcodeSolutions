package HashTable;

//nice ques
public class split_array_into_consecutive_subsequences {
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer,Integer> count=new HashMap<>();
            Map<Integer,Integer> temp=new HashMap<>();

            for(int i=0;i<nums.length;i++){
                count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            }
            for(int i=0;i<nums.length;i++){
                int c=count.getOrDefault(nums[i],0);
                int t=temp.getOrDefault(nums[i],0);
                if(c==0)
                    continue;
                if(t>0){
                    temp.put(nums[i],temp.get(nums[i])-1);
                    count.put(nums[i],count.get(nums[i])-1);
                    temp.put(nums[i]+1,temp.getOrDefault(nums[i]+1,0)+1);
                }
                else if(count.getOrDefault(nums[i],0)>0 && count.getOrDefault(nums[i]+1,0)>0 && count.getOrDefault(nums[i]+2,0)>0){
                    count.put(nums[i],count.get(nums[i])-1);
                    count.put(nums[i]+1,count.get(nums[i]+1)-1);
                    count.put(nums[i]+2,count.get(nums[i]+2)-1);
                    temp.put(nums[i]+3,temp.getOrDefault(nums[i]+3,0)+1);

                }else{
                    return false;
                }

            }
            return true;
        }
    }
}
