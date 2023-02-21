package 프로그래머스.LEVEL2;

import java.util.HashMap;
import java.util.HashSet;

public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int answer = 0;



        HashSet<Integer> hashSet1 = null;
        HashSet<Integer> hashSet2 = null;

        for(int i=0;i<topping.length;i++){
            hashSet1 = new HashSet<>();
            hashSet2 = new HashSet<>();
            for(int j=0;j<i;j++){
                hashSet1.add(topping[j]);
            }
            for(int j=i;j<topping.length;j++){
                hashSet2.add(topping[j]);
            }

            if(hashSet1.size()==hashSet2.size())
                answer++;

        }


        return answer;
    }

}
