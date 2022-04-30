import java.math.BigInteger;

public class 멀리뛰기 {


    public BigInteger pact(int x){
        BigInteger bigRtn = new BigInteger("1");
        for(int i=2;i<=x;i++){
            BigInteger temp = new BigInteger(String.valueOf(i));
            bigRtn = bigRtn.multiply(temp);
        }
        System.out.println(bigRtn);
        return bigRtn;
    }


    public long solution(int n) {

        int minLength =0;
        if(n%2==0){
            minLength = (n/2);
        }
        else{
            minLength = (n/2)+1;
        }

        BigInteger answer = new BigInteger("0");
        int num2 = n/2;
        int num1 = n%2;

        for(int i=0;i<(n/2)+1;i++){

            BigInteger plus = pact(minLength);

            if(num2>1){
                plus = plus.divide(pact(num2));
            }
            if(num1>1){
                plus =plus.divide(pact(num2));

            }
            answer.add(plus);
            minLength+=1;
            num2--;
            num1+=2;
        }

        answer = answer.remainder(new BigInteger("1234567"));
        long retn = answer.longValue();
        return retn;
    }


}
