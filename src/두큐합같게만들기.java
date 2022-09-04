import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<queue1.length;i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            que1.add(Integer.valueOf(queue1[i]));
            que2.add(Integer.valueOf(queue2[i]));
        }

        //숫자 조합으로 값을 같게 만들 수 있는지 CHECK
        if((sum1+sum2)%2!=0){
            return -1;
        }

        int cnt = 0;

        while(sum1!=sum2) {

            cnt++;
            if(cnt == (queue1.length+queue2.length)*2){
                return -1;
            }

            if(sum1>sum2)
            {
                int temp = que1.poll();
                sum1-=temp;
                sum2+=temp;
                que2.add(temp);
            }
            else
            {
                int temp = que2.poll();
                sum1+=temp;
                sum2-=temp;
                que1.add(temp);
            }

        }
        answer =cnt;
        //같아야할 값
        long target = (sum1+sum2)/2;

        return answer;
    }

}
