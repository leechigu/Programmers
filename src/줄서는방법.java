public class 줄서는방법 {

    public int[] solution(int n, long k) {
        int[] answer = {};

        int pac = 1;
        for(int i=1;i<=n;i++){
            pac *=i;
        }

        int numPos = (int) (k/(pac/n));

        System.out.println(numPos);

        return answer;
    }

}

