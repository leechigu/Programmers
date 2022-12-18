import java.util.*;

public class 과일장수 {
    public static int solution(int k, int m, int[] score) {
        int answer =0;

        Arrays.sort(score);

        int maxLen = score.length;

        for(int i = 0;i<score.length;i++){

            if(score[i]>k){
                maxLen = i;
                break;
            }

        }
        int minIndx = (maxLen)%m;
        if(maxLen/m<1){
            return 0;
        }
        for(int i=0; i<maxLen/m; i++){
            answer+= score[minIndx+(i*m)]*m;
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] temp = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(4,3,temp));
    }
}
