package array;

// Array Pattern based question. Using previous state to find next value.
public class Rotate_Function {

    class Solution {
        public int maxRotateFunction(int[] nums) {

            int ts=0;
            int first=0; //calculating only F(0)
            for(int i=0;i<nums.length;i++){
                ts=ts+nums[i];
                first=first+(i*nums[i]);
            }
            int max=Integer.MIN_VALUE;
            max=Math.max(first,max);

            //Calculating other states using just previous states. So for f(1) use F(0)...

            for(int i=0;i<nums.length-1;i++){
                int last=nums[nums.length-i-1];
                int second=first+(ts-last)-((nums.length-1)*last);
                max=Math.max(max,second);
                first=second;
            }

            return max;

        }
    }
}
