package sliding_window;

public class minimum_window_substring {
    class Solution {
        public String minWindow(String s, String t) {

            Map<Character,Integer> map=new HashMap<>();
            for(Character c:t.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }

            int total=map.size();
            int result=Integer.MAX_VALUE;
            int low=0;
            int start=0;
            int right=0;

            for(right=0;right<s.length();right++){
                char ch=s.charAt(right);

                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                    if(map.get(ch)==0){
                        total--;
                    }
                }

                while(low<=right && total==0){

                    if(result>(right-low+1)){
                        result=right-low+1;
                        start=low;
                    }

                    char temp=s.charAt(low);
                    if(map.containsKey(temp)){
                        map.put(temp,map.get(temp)+1);
                        if(map.get(temp)>0){
                            total++;
                        }
                    }
                    low++;
                }
            }

            if(result==Integer.MAX_VALUE)
                return "";
            String res=s.substring(start,start+result);
            return res;


        }
    }
}
