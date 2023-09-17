package QueuePlusDp;

public class Max_Prod_After_K_Increment {
    class Solution {
        public int maximumProduct(int[] nums, int k) {

            long res=1;
            PriorityQueue<Integer> pq=new PriorityQueue<>();

            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
            }

            while(k>0 && !pq.isEmpty()){
                int pol=pq.poll();
                pq.add(pol+1);
                k--;
            }

            while(!pq.isEmpty())
            {
                res=(res*pq.poll())%(1000000000+7);
            }


            return (int)res;



        }
    }
}
