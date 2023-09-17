package monotonic_stack;

public class steps_to_make_array_non_decreasing {
    class Solution {
        public int totalSteps(int[] nums) {

            Stack<int[]> stack=new Stack<>();
            int ans=0;

            for(int i=nums.length-1;i>=0;i--){
                if(stack.isEmpty() || stack.peek()[0]>=nums[i]){
                    stack.push(new int[]{nums[i],0});
                }else{
                    int count=0;
                    while(!stack.isEmpty() && nums[i]>stack.peek()[0]){
                        count++;
                        int temp[]=stack.pop();
                        if(temp[1]>count){
                            count=temp[1];
                        }
                    }
                    stack.push(new int[]{nums[i],count});
                    ans=Math.max(ans,count);


                }

            }
            return ans;

        }

    }
}
