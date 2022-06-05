import java.util.HashMap;
import java.util.HashSet;

public class 방문길이 {
    public int solution(String dirs) {

        int curPos[] = new int[2];
        curPos[0] = 0 ; curPos[1] = 0;
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0;i<dirs.length();i++){
            char changePos = dirs.charAt(i);
            int nextPos[] = new int[2];
            nextPos[0] = curPos[0];  nextPos[1] = curPos[1];
            if(changePos =='U'){
                if(nextPos[1]+1>5)
                    continue;
                nextPos[1]++;
            }
            else if(changePos =='D'){
                if(nextPos[1]-1<-5)
                    continue;
                nextPos[1]--;
            }
            else if(changePos == 'L'){
                if(nextPos[0]-1<-5)
                    continue;
                nextPos[0]--;
            }
            else if(changePos == 'R'){
                if(nextPos[0]+1>5)
                    continue;
                nextPos[0]++;
            }

            String x = String.valueOf(curPos[0])+String.valueOf(curPos[1])+"to"+String.valueOf(nextPos[0])+String.valueOf(nextPos[1]);
            String y = String.valueOf(nextPos[0])+String.valueOf(nextPos[1])+"to"+String.valueOf(curPos[0])+String.valueOf(curPos[1]);
            hashSet.add(x);
            hashSet.add(y);

            curPos[0] = nextPos[0];
            curPos[1] = nextPos[1];

        }
        int answer = hashSet.size()/2;
        return answer;
    }
}
