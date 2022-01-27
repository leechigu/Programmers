public class 삼진법뒤집기 {


    public int solution(int n) {
        int three_n=1;
        int cnt=0;
        while(true){
            three_n =3*three_n;
            cnt++;
            if(n/three_n<1){
                break;
            }

        }
        three_n = three_n/3;
        int []arr = new int[cnt+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = n/three_n;
            n=n-(arr[i]*three_n);
            three_n = three_n/3;
        }
        int x = 1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i]*x;
            x*=3;
        }
        return sum;
    }



}
