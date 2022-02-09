import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int cnt=0;
        int check=0;
        int[] ar = new int[progresses.length];
        for(int i=0;i< progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                ar[i]= (100-progresses[i])/speeds[i];
            }
            else{
                ar[i]= (100-progresses[i])/speeds[i];
                ar[i]+=1;
            }
        }

        int[] temp = new int[ar.length];
        for(int i=0;i<ar.length;i++){
            temp[i] = ar[i];
        }
        Arrays.sort(temp);
        int max = temp[ar.length-1];
        System.out.println(max);


        for(int j=0;j<max;j++){
            for(int i=0;i<ar.length;i++){
                ar[i]--;
            }
            if(ar[check]==0){
                for(int i=check;i<ar.length;i++){
                    if(ar[i]<=0){
                        cnt++;
                        check++;
                    }
                    else{
                        arr.add(cnt);
                        cnt=0;
                        break;
                    }
                }
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

}
