package sliding_window;

public class max_consecutives_ones {
    class Solution {
        public int longestOnes(int[] nums, int k) {


            int result=0;

            int last=0;

            for(int i=0;i<nums.length;i++){

                if(nums[i]==0)
                    k--;

                if(k<0){
                    if(nums[last]==0)
                        k++;
                    last++;
                }


                result=Math.max(result,i-last+1);



            }


            return result;


        }
    }
}

