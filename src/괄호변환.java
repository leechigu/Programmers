import java.util.*;

public class 괄호변환 {


    public static ArrayList<Character> u;
    public static ArrayList<Character> v;




    public boolean checkGoodSt(String st){
        char temp = st.charAt(0);
        if(temp==')')
            return false;
        int count = 1;
        for(int i=1;i<st.length();i++){
            if(st.charAt(i)=='('){
                if(temp ==')'&&count!=0){
                    return false;
                }
                temp ='(';
                count++;
            }
            else{
                temp = ')';
                count--;
                if(count<0)
                    return false;
            }
        }
        if(count==0)
            return true;
        else
            return false;
    }

    public void getUandV(String st){

        int countLeft =0;
        int countRight =0;
        int vStartPoint =1000;
        for(int i=0;i<st.length();i++){
            if((countLeft>0&&countRight>0)&&(countLeft==countRight)) {
                vStartPoint = i;
                break;
            }
            char tempChar = st.charAt(i);
            if(tempChar =='(')
                countLeft++;
            else
                countRight++;
            u.add(tempChar);
        }
        for(int i=vStartPoint;i<st.length();i++){
            v.add(st.charAt(i));
        }
    }

    public String solution(String p) {
        u = new ArrayList<>();
        v = new ArrayList<>();
        Stack<Character> temp = new Stack<>();
        String st = p;
        if(!checkGoodSt(st)){
            getUandV(st);
            String stringU ="";
            String stringV = "";
            for(int i=0;i<u.size();i++){
                stringU+=u.get(i);
            }
            for(int i=0;i<v.size();i++){
                stringV+=v.get(i);
            }

        }


        for(int i=0;i<u.size();i++)
            System.out.print(u.get(i));
        System.out.println();
        for(int i=0;i<v.size();i++)
            System.out.print(v.get(i));
        String answer = "";
        return answer;
    }
}
