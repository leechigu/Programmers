public class 양궁대회 {
    public static int[] max = new int[11];
    public static int totalMax = -1;

    public static void dfs(int[] lion,int[] appeach,int n, int cur){

        if(n==cur){
            check(lion,appeach);
            return;
        }


        for(int i=0;i<11 && lion[i]<=appeach[i];i++){

            lion[i]++;
            dfs(lion,appeach,n,cur+1);
            lion[i]--;
        }

    }

    public static void check(int[] lion,int[] appeach){
        int lionTotal = 0;
        int appeachTotal = 0;
        for(int i=0;i<10;i++){
            if(lion[i]>appeach[i])
                lionTotal+=10-i;
            else if(appeach[i]>0 && appeach[i]>=lion[i])
                appeachTotal+=10-i;

        }

        int gap = lionTotal-appeachTotal;

        if(gap<=0)
            return;
        if(gap==totalMax){
            boolean isMax = false;
            for(int i=10;i>=0;i--){
                if(lion[i]>max[i]){
                    isMax = true;
                    break;
                }
                else if (lion[i]<max[i])
                    break;
            }
            if(isMax){
                for(int i=0;i<11;i++){
                    max[i] = lion[i];
                }
            }
        }
        else if(gap>totalMax){
            totalMax = gap;
            for(int i=0;i<11;i++){
                max[i] = lion[i];
            }
        }

    }


    public int[] solution(int n, int[] info) {

        int[] lion = new int[11];
        int[] appeach = new int[11];

        for(int i=0;i<lion.length;i++){
            lion[i] = 0;
            appeach[i] = info[i];
        }


        dfs(lion,appeach,n,0);

        int cnt =0;
        for(int i=0;i<11;i++)
            cnt+=max[i];
        if(cnt==0){
            int[] rtn = {-1};
            return rtn;
        }


        return max;
    }

}
