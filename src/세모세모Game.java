public class 세모세모Game {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true){
            answer++;
            if(a%2==0){
                a =a/2;
            }
            else {
                a = (a/2)+1;
            }
            if(b%2==0){
                b= b/2;
            }
            else{
                b = (b/2)+1;
            }
            if(a==b)
                break;
        }
        return answer;
    }

}
