import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class KeyPadPress {
    public String solution(String[] participant, String[] completion) {
        String answer ="";

        String[] temp = new String[completion.length];
        temp = completion;
        int []arr = new int[completion.length];
        for(int i =0;i< participant.length;i++){
            int count=0;
            for(int j = 0;j<temp.length;j++){
                if(participant[i].equals(completion[j])) {
                    count++;
                    arr[j]++;
                }
            }
            if(count ==0){
                answer = participant[i];
            }
        }



        return answer;
    }

}
