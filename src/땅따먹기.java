public class 땅따먹기 {


    int solution(int[][] land) {

        for(int i=1;i<land.length;i++){
            land[i][0] += max(land[i-1][1],land[i-1][2],land[i-1][3]);
            land[i][1] += max(land[i-1][0],land[i-1][2],land[i-1][3]);
            land[i][2] += max(land[i-1][1],land[i-1][0],land[i-1][3]);
            land[i][3] += max(land[i-1][1],land[i-1][2],land[i-1][0]);
        }

        return max(land[land.length-1]);
    }

    public int max(int a,int b, int c){
        return Math.max(Math.max(a,b),c);
    }

    public int max(int[] arr){

        int max = -1;
        for(int num :arr){
            max = Math.max(max,num);
        }
        return max;
    }
}
