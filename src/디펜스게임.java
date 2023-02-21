import java.util.Arrays;
import java.util.PriorityQueue;

public class 디펜스게임 {


    public boolean isDefence(int[] enemy,int cnt, int k,int n){

        Arrays.sort(enemy);

        for(int i=0;i<cnt-k;i++){
            n= n-enemy[i];
            if(n<0)
                return false;
        }
        return true;
    }

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        int left=0;
        int right=enemy.length;
        int mid=enemy.length/2;

        while(true){

            if(left==right)
                break;

            if(isDefence(enemy,mid,k,n)){
                mid = (right+mid)/2;
            }else{
                mid = (left+mid)/2;
            }

        }

        answer = mid;

        return answer;
    }

}
