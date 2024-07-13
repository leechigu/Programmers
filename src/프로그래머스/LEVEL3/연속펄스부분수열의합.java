package 프로그래머스.LEVEL3;

import java.util.ArrayList;
import java.util.List;

public class 연속펄스부분수열의합 {

    public long solution(int[] sequence) {


        long answer = 0;
        long case1 = 0;
        long case2 = 0;
        int x = 1;
        for(int cur :  sequence){

            //1 -1 1 ...
            case1 += cur * x;
            //-1 1 -1 ...
            case2 += cur * -x;

            case1 = Math.max(0,case1);
            case2 = Math.max(0,case2);

            answer = Math.max(answer,Math.max(case1,case2));

            x = -x;
        }
        return answer;
    }
}
