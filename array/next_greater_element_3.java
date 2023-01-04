package array;

public class next_greater_element_3 {

    class Solution {
        public int nextGreaterElement(int n) {

            String val=String.valueOf(n);
            int len=val.length();
            char ar[]=val.toCharArray();
            int flag=-1;
            int j=len-1;
            while( j>0 && ar[j]<=ar[j-1])
                j--;
            if(j==0)
                return -1;

            for(int i=len-1;i>0;i--){
                if(ar[j-1]<ar[i]){
                    char temp=ar[i];
                    ar[i]=ar[j-1];
                    ar[j-1]=temp;
                    flag=j;
                    break;
                }
            }
            if(flag==-1)
                return flag;
            List<Character> list=new ArrayList<>();
            for(int i=flag;i<ar.length;i++){
                list.add(ar[i]);
            }
            Collections.sort(list);
            String res="";
            for(int i=0;i<flag;i++)
                res=res+ar[i];
            for(Character i:list)
                res=res+i;
            //more than 32 bit to check
            if(Long.parseLong(res)>Integer.MAX_VALUE)
                return -1;

            return Integer.parseInt(res);




        }
    }
}
