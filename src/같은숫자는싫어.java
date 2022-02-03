import java.util.*;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        int[] answer;
        ArrayList<Integer> arrayList =new ArrayList<>();
        int count =0;
        for(int i =0;i<arr.length;i++){
            if(arrayList.isEmpty()){
                arrayList.add(arr[i]);
                continue;
            }
            else{
                if(arrayList.get(count)!=arr[i]){
                    arrayList.add(arr[i]);
                    count++;
                }
            }
        }
        answer = new int[arrayList.size()];
        Iterator<Integer> it = arrayList.iterator();
        int i=0;
        while(it.hasNext()){
            answer[i] = it.next();
            i++;
        }
        return answer;
    }
}
