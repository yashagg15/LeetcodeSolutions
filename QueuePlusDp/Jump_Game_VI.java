package QueuePlusDp;

public class Jump_Game_VI {
    class Solution {
        public int maxResult(int[] nums, int k) {

            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
            if(nums.length==0)
                return 0;
            pq.add(new int[]{0,nums[0]});

            for(int i=1;i<=nums.length;i++){
                while(!pq.isEmpty() && pq.peek()[0]<i-k)
                    pq.poll();
                int curr=pq.peek()[1];
                if(i!=nums.length)
                    pq.add(new int[]{i,curr+nums[i]});
                else{
                    while(!pq.isEmpty() && pq.peek()[0]<nums.length-1)
                        pq.poll();
                }
            }

            return pq.peek()[1];
        }
    }
}
