package array;


public class Smallest_Intger_divisible_by_K {
    class Solution {
        public int smallestRepunitDivByK(int k) {

            if(k%2==0 || k%5==0)
                return -1;

            Set<Long> mp=new HashSet<>();
            Long start=1l;
            boolean itr=true;
            int len=-1;
            int i=1;

            while(itr){
                long rem=start%k;
                if(rem==0){
                    len=i;
                    break;
                }
                if(mp.contains(rem))
                    break;
                else
                    mp.add(rem);

                start=(rem*10)+1;
                i++;
            }

            return len;

        }
    }
}
