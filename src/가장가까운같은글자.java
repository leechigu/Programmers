import java.util.HashMap;

public class 가장가까운같은글자 {

    public int[] solution(String s) {

        StringBuffer sb = new StringBuffer(s);

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int[] answer = new int[sb.length()];
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(hashMap.containsKey(c)){
                int indx = hashMap.get(c);
                answer[i] = i-indx;
                hashMap.put(c,i);
            }else{
                answer[i] = -1;
                hashMap.put(c,i);
            }
        }

        return answer;
    }

}
