import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
    public void unionSet(Set<Integer> nSet,Set<Integer> set1, Set<Integer> set2){
        for(int a : set1){
            for(int b : set2){
                nSet.add(a+b);
                nSet.add(a-b);
                nSet.add(a*b);
                if(b!=0){
                    nSet.add(a/b);
                }
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> arrayList = new ArrayList<>();
        for(int i=0;i<9;i++){
            arrayList.add(new HashSet<Integer>());
        }
        arrayList.get(1).add(N);
        if(number == N)
            return 1;
        for(int i=2;i<9;i++){
            for(int j=1;j<=i/2;j++){
                unionSet(arrayList.get(i),arrayList.get(i-j),arrayList.get(j));
                unionSet(arrayList.get(i),arrayList.get(j),arrayList.get(i-j));
            }
            String n = Integer.toString(N);
            arrayList.get(i).add(Integer.parseInt(n.repeat(i)));
        }
        for(int i=0;i<9;i++){
            for(int x : arrayList.get(i)){
                if(number==x){
                    return i;
                }
            }
        }
        return -1;
    }
}
