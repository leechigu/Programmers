import java.util.Stack;

public class 햄버거만들기 {

    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb =  new StringBuilder();
        for(int i=0;i<ingredient.length;i++){
            sb.append(ingredient[i]);
            if(sb.length()>3&&sb.substring(sb.length()-4,sb.length()).equals("1231")){
                sb.replace(sb.length()-4,sb.length(),"");
                answer++;
            }
        }
        return answer;
    }


}
