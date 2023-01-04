package array;

public class h_Index {
    class Solution {

        public int hIndex(int[] citations) {

            Arrays.sort(citations);
            int result=0;
            int n=citations.length;
            if(n==0)
                return 0;


            for(int i=1;i<=n;i++){
                if(n==i){
                    if(citations[n-i]>=i)
                        result=Math.max(result,i);
                }else{
                    if(citations[n-i-1]<=i && (n-i)<n && citations[n-i]>=i)
                        result=Math.max(result,i);
                }
            }
            return result;



        }
    }
}
