import java.util.*;

public class 다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<bridge_length;i++)
        {
            queue.add(0);
        }
        int sum =0;

        Arrays.sort(truck_weights);
        System.out.println(truck_weights[0]);

        System.out.println(queue.size());
        int answer = 0;
        return answer;
    }
}
