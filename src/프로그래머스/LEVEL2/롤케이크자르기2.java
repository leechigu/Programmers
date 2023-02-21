package 프로그래머스.LEVEL2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class 롤케이크자르기2 {

    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        HashSet<Integer> hashSet = new HashSet<>();

        for(int temp : topping){
            if(hashMap.containsKey(temp)){
                hashMap.replace(temp,hashMap.get(temp)+1);
            }
            else{
                hashMap.put(temp,1);
            }
        }

        for(int i=0;i<topping.length;i++){

            int temp = topping[i];

            hashSet.add(temp);

            hashMap.replace(temp,hashMap.get(temp)-1);
            if(hashMap.get(temp)==0)
                hashMap.remove(temp);

            if(hashSet.size()==hashMap.size())
                answer++;

        }



        return answer;
    }
}
