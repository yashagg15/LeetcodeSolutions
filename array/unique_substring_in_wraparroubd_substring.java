package array;

public class unique_substring_in_wraparroubd_substring {
    class Solution {
        public int findSubstringInWraproundString(String p) {

            int count[]=new int[26];
            int c=0;
            for(int i=0;i<p.length();i++){

                if(i!=0 && ( (p.charAt(i)-p.charAt(i-1))==1 || (p.charAt(i-1)-p.charAt(i))==25 )){
                    c++;
                }
                else{
                    c=1;
                }
                count[p.charAt(i)-'a']=Math.max(c,count[p.charAt(i)-'a']);

            }

            int res=0;
            for(int i=0;i<count.length;i++){
                res=res+count[i];
            }

            return res;
        }
    }
}
