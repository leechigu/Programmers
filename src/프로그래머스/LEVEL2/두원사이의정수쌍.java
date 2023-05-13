package 프로그래머스.LEVEL2;

import java.math.BigInteger;

public class 두원사이의정수쌍 {
    public boolean isInteger(double num) {
        return num % 1 == 0.0;
    }

    public long circleDot(int r,boolean isFirst){
        long answer = 0;

        BigInteger r2 = new BigInteger(String.valueOf(r));
        r2 = r2.multiply(r2);
        System.out.println("--------------");
        System.out.println("r = " + r);
        for(int i=1;i<=r;i++){

            BigInteger x = new BigInteger(String.valueOf(i));
            x = x.multiply(x);
            long dis = Long.valueOf(r2.subtract(x).toString());
            int sqrt;

            double temp =Math.sqrt(dis);
            if(isInteger(temp)&&!isFirst){
                sqrt = (int) Math.sqrt(dis)-1;
            }else{
                sqrt = (int) Math.sqrt(dis);
            }
            answer+=sqrt;
        }

        answer+=r-1;
        System.out.println("answer = " + answer*4);
        System.out.println("--------------");
        return answer*4;
    }


    public long solution(int r1, int r2) {


        return circleDot(r2,true)-circleDot(r1,false);

    }

}
