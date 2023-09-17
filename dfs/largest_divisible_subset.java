package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// nice ques using hashmap as storing previous state values dp+recursion/dfs
public class largest_divisible_subset {
    class Solution {

        Map<Integer,List<Integer>> mp=new HashMap<>();

        public List<Integer> largest(int[] nums,int index,int previous){

            if(mp.containsKey(index)){
                return mp.get(index);
            }
            List<Integer> t=new ArrayList<>();
            for(int i=index;i<nums.length;i++){
                if((nums[i]%previous)==0){
                    List<Integer> l=new ArrayList<>(largest(nums,i+1,nums[i]));
                    l.add(nums[i]);
                    if(l.size()>t.size()){
                        t=l;
                    }

                }
            }

            mp.put(index,t);
            return t;

        }


        public List<Integer> largestDivisibleSubset(int[] nums) {

            mp=new HashMap<>();
            Arrays.sort(nums);
            int previous=1;
            return largest(nums,0,1);

        }
    }
}
