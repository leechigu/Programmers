import java.util.HashSet;
import java.util.Iterator;

public class 소수찾기 {
    public static HashSet<Integer> arr;


    public static void dfs(String numbers,String st,int cur,int target,boolean[] isVisited){

        if(target==cur){
            checkPrime(st);
            return;
        }



        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                st+=numbers.charAt(i);
                dfs(numbers,st,cur+1,target,isVisited);
                st = st.substring(0,st.length()-1);
                isVisited[i] =false;
            }
        }

    }

    public static void checkPrime(String st){
        int temp = Integer.parseInt(st);
        int sqrt = (int) Math.sqrt(temp);
        boolean isPrime = true;
        if(temp==1){
            return;
        }
        for(int i=2;i<=sqrt;i++){
            if(temp%i==0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            arr.add(temp);
        }
    }

    public int solution(String numbers) {
        arr = new HashSet<>();

        for(int i=1;i<=numbers.length();i++){
            boolean[] isVisited = new boolean[numbers.length()];
            dfs(numbers,"",0,i,isVisited);
        }

        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        int answer = arr.size();
        return answer;
    }

}
