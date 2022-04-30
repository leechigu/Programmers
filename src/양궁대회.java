public class 양궁대회 {

    public static int[] lion ;
    public static int[] apeach;
    public static int cnt;
    public static int max =-1;
    public static int[] maxTarget=  new int[11];
    public static int x = 0;


    public static void dfs(int depth){
        if(depth == cnt){
            total();
            return;
        }
        for(int i=x;i<11;i++){
            lion[i]++;
            dfs(depth+1);
            lion[i]--;
        }
    }

    public static void total(){
        int lionScore=0;
        int apeachScore=0;
        for(int i=x;i<11;i++){
            if(lion[i]==0&&apeach[i]==0)
                continue;
            if(lion[i]>apeach[i])
                lionScore+=10-i;
            else
                apeachScore+=10-i;
        }
        if(apeachScore>=lionScore){
            return;
        }
        if(lionScore-apeachScore>max) {
            max = lionScore-apeachScore;
            for(int i=0;i<11;i++)
                maxTarget[i] = lion[i];
        }
        else if(lionScore-apeachScore == max && max>-1){
            for(int i=10;i>=0;i--){
                if(lion[i]>maxTarget[i]){
                    for(int j=0;j<11;j++){
                        maxTarget[j] = lion[j];
                    }
                    break;
                }

            }
        }
    }
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        for(int i=0;i<11;i++)
            lion[i] =0;

        apeach = info;
        cnt =n;
        for(int i=0;i<11;i++){
            if(apeach[i]==0||apeach[i]==1){
                if(cnt==0){
                    x = i;
                    break;
                }

                cnt--;
                lion[i]++;
            }
            else
                break;
        }
        System.out.println(cnt);
        dfs(0);
        if(max<=0){
            return new int[]{-1};
        }
        else{
            return maxTarget;
        }
    }

}
