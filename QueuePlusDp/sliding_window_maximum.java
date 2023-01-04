package QueuePlusDp;

public class sliding_window_maximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int result[]=new int[nums.length-k+1];
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
            for(int i=0;i<k;i++){
                pq.add(new int[]{i,nums[i]});
            }
            int j=0;
            for(int i=k;i<=nums.length;i++){
                result[j]=pq.peek()[1];
                // for this TC [9,10,9,-7,-4,-8,2,-6] while loop
                while(!pq.isEmpty() && (i-k)>=pq.peek()[0] )
                    pq.poll();
                if(i!=nums.length)
                    pq.add(new int[]{i,nums[i]});
                j++;
            }
            return result;

        }
    }
}
