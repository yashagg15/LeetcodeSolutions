package two_pointers;

public class BoatstoSavePeople {

    class Solution {

        public int numRescueBoats(int[] people, int limit) {

            Arrays.sort(people);
            int low=0;
            int high=people.length-1;
            int result=0;
            while(low<=high){
                int sum=(low!=high)?people[low]+people[high]:people[low];
                if(sum<=limit){
                    result++;
                    low++;
                    high--;
                }else{
                    result++;
                    high--;
                }
            }
            return result;


        }
    }

}
