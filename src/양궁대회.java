public class 양궁대회 {

    public static int[] lion ;
    public static int[] apeach;
    public static int cnt;
    public static int max =-1;
    public static int[] maxTarget;
    public static void dfs(int depth){

        if(depth == cnt){
            total();
            return;
        }
        for(int i=0;i<11;i++){
            lion[i]++;
            dfs(depth+1);
            lion[i]--;
        }
    }

    public static void total(){
        int lionScore=0;
        int apeachScore=0;
        for(int i=0;i<11;i++){
            if(lion[i]==0&&apeach[i]==0)
                continue;
            if(lion[i]>apeach[i])
                lionScore+=10-i;
            else
                apeachScore+=10-i;
        }
        if(apeachScore>lionScore){
            return;
        }
        else{
            if(lionScore-apeachScore>max) {
                max = lionScore-apeachScore;
                maxTarget = new int[11];
                for(int i=0;i<11;i++){
                    maxTarget[i] = lion[i];
                }
            }
            else if(lionScore-apeachScore==max){
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
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        for(int i=0;i<11;i++){
            lion[i] =0;
        }
        apeach = info;
        for(int i=0;i<11;i++)
            System.out.println(apeach[i]);
        cnt =n;
        dfs(0);
        if(max==-1){
            return new int[]{-1};
        }
        else{
            return maxTarget;
        }
    }

}
