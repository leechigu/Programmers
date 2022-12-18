import java.util.*;

public class 명예의전당 {

    public int[] solution(int k, int[] score) {
        int[] arr = new int[score.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = 10000;
        }
        int[] answer = new int[score.length];
        for(int i=0; i<k; i++){
            arr[i] = score[i];
            Arrays.sort(arr);
            answer[i] = arr[0];
        }
        Arrays.sort(arr);
        for(int i=k;i<score.length;i++){
            if(arr[0]>score[i]){
                arr[0] = score[i];
                Arrays.sort(arr);
                answer[i] = arr[0];
            }
        }
        return answer;
    }

}
