import java.math.BigInteger;
import java.util.*;

public class 다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> stack = new Stack<>();
        for(int i=truck_weights.length-1;i>=0;i--){
            stack.push(truck_weights[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<bridge_length;i++)
            queue.add(0);
        int truck = stack.pop();
        queue.add(truck);

        boolean t = true;
        queue.poll();
        int size = queue.size();

        int totalWeight = truck;
        int answer = 1;
        while(true){
            if(!stack.isEmpty()){
                if (totalWeight + stack.peek() <= weight) {
                    totalWeight-=queue.poll();
                    int temp = stack.pop();
                    queue.add(temp);
                    totalWeight +=temp;
                }
                else{
                    if(stack.peek()+totalWeight- queue.peek()<=weight){
                        int temp = queue.poll();
                        totalWeight-=temp;
                        int x = stack.pop();
                        queue.add(x);
                        totalWeight+=x;
                    }
                    else{
                        int temp = queue.poll();
                        totalWeight-=temp;
                        queue.add(0);
                    }
                }
                answer++;
            }

            if(stack.isEmpty()){
                answer+=bridge_length;
                break;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        BigInteger tem = new BigInteger("36");
        BigInteger tem2 = new BigInteger("15");

        String dd = Integer.toString(100,3);

        System.out.println(Integer.parseInt(dd));
    }
}
