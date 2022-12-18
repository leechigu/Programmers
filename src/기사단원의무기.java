public class 기사단원의무기 {


    public int dirtn(int x){

        int rtn = 0;
        int sqt = (int) Math.sqrt(x);

        for(int i=1;i<=sqt;i++){
            if(x%i==0){
                if(i*i==x)
                    rtn++;
                else
                    rtn+=2;
            }
        }

        return rtn;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){

            int t = dirtn(i);
            if(t>limit){
                answer+=power;
            }
            else{
                answer+=t;
            }

        }
        return answer;
    }


}
