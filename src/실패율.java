import java.util.ArrayList;
import java.util.Arrays;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[][] fail = new int[N][2];
        boolean[] isChecked = new boolean[N];
        int[] answer = new int[N];
        int temp;
        for(int i= 0;i<N;i++){
            isChecked[i] = false;
        }

        for(int i = 0 ;i<stages.length; i++){
            temp = stages[i];
            if(temp == N+1){
                continue;
            }
            if(!isChecked[temp-1]){
                for(int j =0 ; j<stages.length; j++){
                    if(stages[j] >= temp){
                        fail[temp-1][1]++;
                    }
                    if(stages[j]==temp){
                        fail[temp-1][0]++;
                    }
                }
                isChecked[temp-1] = true;
            }
        }

        float[] ratio = new float[N];
        for(int i=0;i<fail.length;i++){
            if(fail[i][1]==0)
                ratio[i]=0;
            else{
                ratio[i] = (float)fail[i][0]/(float)fail[i][1];
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(ratio[i]);
        }
        float[]tra = new float[N];
        for(int i =0;i<N;i++){
            tra[i] = ratio[i];
        }
        Arrays.sort(ratio);
        for(int i= 0;i<N;i++){
            isChecked[i] = false;
        }
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++){
                if(ratio[i]==tra[j]){
                    if(!isChecked[j]){
                        isChecked[j] = true;
                        answer[N-1-i] = j+1;
                        break;
                    }
                }
            }
        }
        return answer;
    }


}
