import java.util.*;
public class 더맵게 {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++){
            priorityQueue.offer(scoville[i]);
        }

        /*Iterator<Integer> it = priorityQueue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        int answer =0;
        for(int i=0;i<priorityQueue.size();i++){
            if(priorityQueue.peek()<K){
                if(priorityQueue.size()>1){
                    int x,y;
                    x = priorityQueue.poll();
                    y = priorityQueue.poll();
                    priorityQueue.offer(x+2*y);
                    answer++;
                    i--;
                }
                else{
                    return -1;
                }
            }
        }
        return answer;
    }
}
