import java.util.*;

public class 가장큰수 {


    static int arr[];
    static int[] visited;
    static int len;
    static String temp="";
    static ArrayList<String> st;
    public static void dfs(int n){
        if(n==len){
            st.add(temp);
            temp ="";
            return ;
        }
        for(int i=0;i<arr.length;i++){
            if(visited[i]==0){
                temp += String.valueOf(arr[i]);
                visited[i] = 1;
                dfs(n+1);
                visited[i] = 0;
            }
        }


    }


    public String solution(int[] numbers) {

        len = numbers.length;
        arr = numbers;
        visited =new int[len];
        st = new ArrayList<>();
        for(int i=0;i<len;i++){
            visited[i] = 0;
        }
        dfs(0);
        Iterator<String> it = st.iterator();
        int max= 0;

        while(it.hasNext()){
            int t = Integer.parseInt(it.next());
            if(t>=max)
                max = t;
        }
        return String.valueOf(max);
    }


}
