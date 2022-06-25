import java.util.ArrayList;

public class 삼차_압축 {
    public int[] solution(String msg) {
        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();


        //A~Z 까지 집어넣어
        for(int i=65;i<=90;i++){
            String a = String.valueOf((char) i);
            arrayList.add(a);
        }

        for(int i=0;i<msg.length();i++){
            if(i==msg.length()-1){
                int ind = arrayList.indexOf(String.valueOf(msg.charAt(i)));
                answerList.add(ind+1);
                break;
            }
            String next = "";
            int indx = -1;
            for(int j=i;j<msg.length();j++){
                next += String.valueOf(msg.charAt(j));
                if(!arrayList.contains(next)) {
                    break;
                } else {
                    i++; indx = arrayList.indexOf(next);
                }
            }
            i--;
            answerList.add(indx+1);
            arrayList.add(next);
        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
            answer[i] = answerList.get(i);
        return answer;
    }
}
