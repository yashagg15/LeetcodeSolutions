package array;

public class three_sum_with_multiplicity {
    class Solution {
        public int threeSumMulti(int[] arr, int target) {

            long result=0;
            Arrays.sort(arr);
            for(int i=0;i<arr.length-2;i++){
                int tot=arr[i];
                int l=i+1;
                int r=arr.length-1;
                while(l<r){
                    tot=arr[i]+arr[l]+arr[r];
                    if(tot>target){
                        r--;
                    }
                    else if(tot<target){
                        l++;
                    }
                    else{

                        int count1=1;
                        int count2=1;
                        if(arr[l]==arr[r]){
                            int len=r-l+1;
                            result=result+(len*(len-1))/2;
                            break;
                        }

                        while(l<r && arr[l]==arr[l+1]){
                            count1++;
                            l++;
                        }
                        while(l<r && arr[r]==arr[r-1]){
                            count2++;
                            r--;
                        }
                        result=result+(count1*count2);
                        l++;
                        r--;

                    }
                }

            }
            return (int)(result%1000000007);

        }
    }
}
