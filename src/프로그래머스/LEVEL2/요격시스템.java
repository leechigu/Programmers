package 프로그래머스.LEVEL2;
import java.util.*;
public class 요격시스템
{
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        boolean[] isClear  = new boolean[targets.length];

        for(int i =0;i<targets.length;i++){
            if(!isClear[i]){
                int[] cur = targets[i];
                isClear[i] = true;
                answer++;
                for(int j=i+1;j<targets.length;j++){
                    if(isClear[j])
                        continue;
                    int[] temp = targets[j];
                    if(cur[1]>temp[0]&&cur[1]<=temp[1]){
                        isClear[j] = true;
                    }
                }
            }
        }

        return answer;
    }

}
