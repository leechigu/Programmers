import java.util.ArrayList;
import java.util.Comparator;

public class 카펫 {


    public int[] solution(int brown, int yellow) {


        int sqrt = (int) Math.sqrt(yellow);
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= sqrt; i++){
            if(yellow % i == 0){
                arr.add(i);
                if(yellow / i != i){
                    arr.add(yellow / i);
                }
            }
        }
        arr.sort(Comparator.naturalOrder());

        int[] answer = new int[2];
        for(int i=0;i<arr.size();i++){
            int x = arr.get(i);
            int y = yellow/x;

            if((2*x)+(2*y)+4==brown){
                answer[0] = Math.max(x,y)+2;
                answer[1] = Math.min(x,y)+2;
                break;
            }

        }
        return answer;
    }


}
