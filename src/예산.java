import java.util.Arrays;
public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt =0;
        for(int i=0;i<d.length;i++){
            budget-= d[i];
            if(budget<0)
                break;
            cnt++;
        }
        return cnt;
    }
}
