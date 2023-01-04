package HashTable;

//HashTable kind of HashMap related ques
public class longest_string_chain {
    class Solution {
        public int longestStrChain(String[] words) {

            int result=Integer.MIN_VALUE;

            List<String> list=new ArrayList<>();
            for(String s:words)
                list.add(s);
            list.sort((a,b)->a.length()-b.length());

            Map<String,Integer> map=new HashMap<>();

            for(int i=0;i<list.size();i++){

                String word=list.get(i);
                map.put(word,1);

                for(int j=0;j<word.length();j++){
                    StringBuilder sb=new StringBuilder(word);
                    String prev=sb.deleteCharAt(j).toString();
                    if(map.containsKey(prev) && (map.get(prev))+1>map.get(word)){
                        map.put(word,map.get(prev)+1);
                    }
                }

                result=Math.max(result,map.get(word));

            }

            return result;
        }
    }
}
