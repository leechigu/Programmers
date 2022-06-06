public class 삼각달팽이 {
    public static int[] solution(int n) {


        int totalNum  = 0;
        for(int i=1;i<=n;i++){
            totalNum +=i;
        }

        int[][] arr= new int[n][];
        for(int i=0;i<n;i++){
            arr[i] = new int[i+1];
        }


        int numCnt = 1;
        int caseCnt = n;
        int x = 0;
        int y = 0;
        int z = 0;
        while(true){
            if(caseCnt ==0){
                break;
            }
            for(int i=2*x;i<n-x;i++){
                arr[i][x] = numCnt;
                numCnt++;
            }
            x++;
            caseCnt--;
            if(caseCnt ==0){
                break;
            }
            for(int i=y+1;i<n-(2*y);i++){
                arr[n-y-1][i] = numCnt;
                numCnt++;
            }
            y++;
            caseCnt--;
            if(caseCnt ==0){
                break;
            }
            int l = 0;
            for(int i=n-2-z;i>(2*z);i--){
                arr[i][n-2-(z*2)-l] = numCnt;
                l++;
                numCnt++;
            }
            z++;
            caseCnt--;
        }


        int[] answer = new int[totalNum];

        int cur = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                answer[cur] = arr[i][j];
                cur++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution(6);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
