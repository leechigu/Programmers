import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                ans.add(arr[i]);
            }
        }
        int[] answer =  new int[ans.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        if(answer.length>0){
            return answer;
        }
        else{
            int[] empty = {-1};
            return empty;
        }
    }
}
