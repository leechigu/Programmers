public class 일차비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer =new String[n];
        for(int i=0;i<n;i++){
            answer[i] ="";
        }
        if(n==1){

            if(arr1[0]+arr2[0]>=1){
                answer[0] = "#";
            }
            else
                answer[0] = " ";
            return answer;
        }


        int[][] x = new int[n][n];
        int[][] y = new int[n][n];
        int a =1;
        System.out.println(a);
        for(int i=0;i<n;i++){
            a= a*2;
        }
        System.out.println(a);
        int b=a;
        int temp =a;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a = a/2;
                x[i][j] = arr1[i]/a;
                arr1[i] = arr1[i] - a*x[i][j];

                b = b/2;
                y[i][j] = arr2[i]/b;
                arr2[i] = arr2[i] - b*y[i][j];
            }
            a =temp;
            b =temp;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]+y[i][j]>=1)
                    answer[i]+="#";
                else
                    answer[i]+=" ";
            }
        }
        return answer;
    }
}
