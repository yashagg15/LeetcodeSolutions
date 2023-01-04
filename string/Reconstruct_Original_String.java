package string;

public class Reconstruct_Original_String {
    class Solution {
        public String originalDigits(String s) {

            String str[]={"zero","two","four","six","eight","one","three","five","seven","nine"};
            char ch[]={'z','w','u','x','g','o','h','f','s','n'};
            int val[]={0,2,4,6,8,1,3,5,7,9};

            Map<Character,Integer> mp=new HashMap<>();

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(!mp.containsKey(s.charAt(i)))
                    mp.put(s.charAt(i),1);
                else
                    mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }
            List<Integer> res=new ArrayList<>();

            for(int i=0;i<ch.length;i++){
                while(mp.containsKey(ch[i])){
                    String temp=str[i];
                    res.add(val[i]);
                    for(int j=0;j<temp.length();j++){
                        char it=temp.charAt(j);
                        if(mp.containsKey(it)){
                            mp.put(it,mp.get(it)-1);
                            if(mp.get(it)==0)
                                mp.remove(it);
                        }
                    }
                }
            }
            Collections.sort(res);
            for(Integer i:res){
                sb.append(String.valueOf(i));
            }
            return sb.toString();



        }
    }
}
