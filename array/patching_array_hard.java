package array;

public class patching_array_hard {

    class Solution {

        public int minPatches(int[] nums, int n) {

            long sum=1;
            int patchCount=0;

            for(int i=0;i<nums.length;i++){
                if(sum>n)
                    break;
                if(sum<nums[i]){
                    patchCount++;
                    i--;
                    sum=2*sum;
                }
                else if(sum==nums[i]){
                    sum=2*sum;
                }
                else if(sum>nums[i]){
                    sum=sum+nums[i];
                }


            }

            while(sum<=n){
                patchCount++;
                sum=sum*2;
            }
            return patchCount;
        }
    }
}
