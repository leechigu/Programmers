import java.util.Locale;

public class 문자열내p와y개수 {
    boolean solution(String s) {
        boolean answer;
        s.toLowerCase();
        System.out.println(s);
        int p =0;
        int y =0;
        StringBuffer st = new StringBuffer(s);
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='p')
                p++;
            else if(st.charAt(i)=='y')
                y++;
        }
        if(p==y)
            answer = true;
        else
            answer = false;
        return answer;
    }
}
