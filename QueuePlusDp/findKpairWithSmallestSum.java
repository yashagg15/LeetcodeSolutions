package QueuePlusDp;
//PriorityQueue Problem
public class findKpairWithSmallestSum {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            // Map<Integer,List<List<Integer>> mp=new HashSet<>();

            PriorityQueue<int[]> pq=new PriorityQueue<>(
                    (a,b)->{
                        if((a[0]+a[1])<=(b[0]+b[1]))
                            return -1;
                        return 1;
                    }
            );
            int i=0;

            while(i<k && i<nums1.length){
                int[] temp=new int[]{nums1[i],nums2[0],0};
                pq.add(temp);
                i++;
            }

            int j=0;
            List<List<Integer>> res=new ArrayList<>();
            while(j<k && !pq.isEmpty()){

                int t[]=pq.poll();
                List<Integer> temp=new ArrayList<>();
                temp.add(t[0]);
                temp.add(t[1]);
                res.add(temp);
                int index=t[2];
                if((index+1)<nums2.length)
                    pq.add(new int[]{t[0],nums2[index+1],index+1});
                j++;
            }
            return res;


        }
    }
}
