
import java.util.*;

public class MarathonNo {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for(int i=0;i< participant.length;i++){
            if(i== participant.length-1){
                answer = participant[participant.length-1];
                return answer;
            }
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                return answer;
            }

        }
        return answer;
    }
}
