import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class 두개뽑아서더하기 {


    public int[] solution(int[] numbers) {

        HashSet<Integer> hashSet = new HashSet<>();
        int sum;
        for(int i=0;i<numbers.length-1;i++){
            sum = 0;
            for(int j=i+1;j<numbers.length;j++){
                sum = numbers[i]+numbers[j];
                hashSet.add(sum);
            }
        }
        int[] answer = new int[hashSet.size()];

        Iterator<Integer> it = hashSet.iterator();
        int i=0;
        while(it.hasNext()){
            answer[i] = it.next();
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }

}
