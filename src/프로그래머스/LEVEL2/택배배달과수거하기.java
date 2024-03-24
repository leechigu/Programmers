package 프로그래머스.LEVEL2;

import java.util.*;

public class 택배배달과수거하기 {


    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<int[]> delivery = new Stack<>();

        for(int i=0;i<deliveries.length;i++){
            if(deliveries[i]>0) {
                delivery.add(new int[]{i, deliveries[i]});
            }
        }

        Stack<int[]> pickup = new Stack<>();
        for(int i=0;i<pickups.length;i++){
            if(pickups[i]>0) {
                pickup.add(new int[]{i, pickups[i]});
            }
        }

        while(true){
            if(delivery.isEmpty()&& pickup.empty()){
                break;
            }
            //case1
            int truck = cap;

            int[] d = !delivery.isEmpty() ? delivery.peek() : new int[]{0,0};
            int[] p = !pickup.isEmpty()?pickup.peek(): new int[]{0,0};


            //왕복 거리 체크용
            int length = Math.max(d[0],p[0]);
            answer += length*2;
            //delivery 소비
            while(true){
                if(delivery.isEmpty())
                    break;
                d = delivery.pop();
                if(truck>=d[1]) {
                    truck -= d[1];
                }
                else{
                    d[1] -= truck;
                    delivery.add(new int[]{d[0],d[1]});
                    break;
                }
            }
            truck = cap;
            //pick 소비
            while(true){
                if(pickup.isEmpty())
                    break;
                p = pickup.pop();
                if(truck>=p[1]) {
                    truck -= p[1];
                }
                else{
                    p[1] -= truck;
                    delivery.add(new int[]{p[0],p[1]});
                    break;
                }
            }
        }
        return answer;
    }

}
