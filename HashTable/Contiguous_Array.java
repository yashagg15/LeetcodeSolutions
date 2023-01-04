package HashTable;


//HashMap nice ques
public class Contiguous_Array {
    class Solution {
        public int findMaxLength(int[] nums) {

            Map<Integer,Integer> mp=new HashMap<>();
            int res=0;
            mp.put(0,-1);
            int point=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==1)
                    point++;
                else
                    point--;
                if(mp.containsKey(point)){
                    res=Math.max(res,i-mp.get(point));
                }
                else
                    mp.put(point,i);

            }
            return res;


        }
    }
}
