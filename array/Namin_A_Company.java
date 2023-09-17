package array;

public class Namin_A_Company {

    class Solution {
        public long distinctNames(String[] ideas) {

            Set<String> ar[]=new Set[26];

            for(int i=0;i<ar.length;i++)
                ar[i]=new HashSet<>();

            for(String str:ideas){
                int index=str.charAt(0)-'a';
                ar[index].add(str.substring(1));
            }

            long result=0;

            for(int i=0;i<ar.length;i++){

                for(int j=i+1;j<ar.length;j++){

                    long common=0;

                    for(String a:ar[i]){
                        if(ar[j].contains(a)){
                            common++;
                        }
                    }

                    result=result+2*(ar[i].size()-common)*(ar[j].size()-common);
                }
            }
            return result;

        }
    }
}
