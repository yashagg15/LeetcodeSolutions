package sliding_window;

public class Count_subarray_with_max_bounds {

    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {


            int start=0;
            int minInd=0;
            int maxInd=0;
            boolean minStart=false;
            boolean maxStart=false;
            long count=0;

            for(int i=0;i<nums.length;i++){

                if(nums[i]<minK || nums[i]>maxK){
                    start=i+1;
                    minStart=false;
                    maxStart=false;

                }

                if(nums[i]==minK){
                    minStart=true;
                    minInd=i;
                }

                if(maxK==nums[i]){
                    maxStart=true;
                    maxInd=i;

                }

                if(minStart && maxStart){
                    count=count+ Math.min(minInd,maxInd)-start+1;
                }



            }

            return count;
        }
    }
}
