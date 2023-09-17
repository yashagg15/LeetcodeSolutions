package string;

public class ValidParenthesisString {

    class Solution {
        public boolean checkValidString(String s) {

            int left=0;
            int stars=0;

            Stack<String> st=new Stack<>();

            for(int i=0;i<s.length();i++){

                if(s.charAt(i)=='('){
                    st.push("(");
                    stars++;
                }
                else if(s.charAt(i)=='*'){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                    stars++;
                }
                else if(!st.isEmpty() && s.charAt(i)==')'){
                    st.pop();
                    stars--;
                }else if(st.isEmpty() && s.charAt(i)==')' && stars>0){
                    stars--;
                }
                else{

                    return false;
                }

            }



            return st.isEmpty();
        }
    }
}
