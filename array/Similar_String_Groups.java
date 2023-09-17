package array;

// dfs hard
public class Similar_String_Groups {

    class Solution {

        public void setGroup(String[] strs, String first){

            for(int i=0;i<strs.length;i++){
                if(strs[i]==null)
                    continue;
                boolean same= compareString(first,strs[i]);
                if(same){
                    String temp=strs[i];
                    strs[i]=null;
                    setGroup(strs,temp);
                }
            }

        }

        public boolean compareString(String first, String second){
            int c=0;
            if(first.equals(second))
                return true;
            if(first.length()!=second.length())
                return false;
            int i=0;
            while(c<=2 && i<first.length()){
                if(first.charAt(i)!=second.charAt(i)){
                    c++;
                }
                i++;
            }
            if(c==2)
                return true;

            return false;

        }

        public int numSimilarGroups(String[] strs) {

            int res=0;
            for(int i=0;i<strs.length;i++){
                if(strs[i]==null)
                    continue;
                String temp=strs[i];
                strs[i]=null;
                setGroup(strs,temp);
                res++;
            }
            return res;

        }
    }
}
