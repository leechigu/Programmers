import java.util.ArrayList;

public class NewIdRecommend {
    public int solution(String s) {
        String temp = s;
        String[] eng = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String num ="";
        String x="";
        ArrayList<String> term  =  new ArrayList<>();
        for(int i = 0 ;i<eng.length;i++){
            term.add(eng[i]);
        }
        for(int i = 0; i<temp.length();i++){
            if(temp.charAt(i)>='0'&&temp.charAt(i)<='9'){
                num+=temp.charAt(i);
            }
            else{
                x+=temp.charAt(i);
                for(int j=0;j<eng.length;j++){
                    if(x.equals(eng[j])){
                        num+=j;
                        x="";
                    }
                }
            }
        }
        int answer = Integer.parseInt(num);
        return answer;
    }
}
