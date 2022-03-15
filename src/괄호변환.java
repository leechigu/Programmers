import java.util.*;

public class 괄호변환 {
    public boolean isNul(String st){
        if(st.length()==0)
            return true;
        else
            return false;
    }
    public boolean isBlancedString(String st){
        int cntLeft =0;
        int cntRight = 0;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='(')
                cntLeft++;
            else
                cntRight++;
        }
        if(cntLeft==cntRight)
            return true;
        else
            return false;
    }
    public boolean isOptimal(String st){
        if(st.length()<2)
            return false;
        if(!isBlancedString(st))
            return false;
        Stack<Character> stack = new Stack<>();
        if(st.charAt(0)!='(')
            return false;
        char start = '(';
        stack.push('(');
        for(int i=1;i<st.length();i++){
            if(st.charAt(i)=='(')
                stack.add('(');
            else{
                if(stack.isEmpty())
                    return false;
                if(stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        else
            return true;
    }
    public String[] StringSlice(String st){
        String[] temp = new String[2];
        int cntLeft =0;
        int cntRight = 0;
        int pos =-1;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='(')
                cntLeft++;
            else
                cntRight++;
            if(cntLeft==cntRight) {
                pos = i;
                break;
            }
        }
        temp[0] = st.substring(0,pos+1);
        temp[1] = st.substring(pos+1);
        return temp;
    }
    public String flipString(String st){
        String res ="";
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='(')
                res+=')';
            else
                res+='(';
        }
        return res;
    }
    public String totalFlow(String st){
        if(isNul(st)){
            return "";
        }
        if(isOptimal(st))
            return st;
        String[] stUV;
        stUV = StringSlice(st);
        String u = stUV[0];
        String v = stUV[1];
        if(isOptimal(u)){
            String res = totalFlow(v);
            u+=res;
            return u;
        }
        else{
            String temp = "(";
            String res = totalFlow(v);
            temp+=res;
            temp+=")";
            u = u.substring(1,u.length()-1);
            u = flipString(u);
            temp +=u;
            return temp;
        }
    }

    public String solution(String p) {
        return totalFlow(p);
    }
}
