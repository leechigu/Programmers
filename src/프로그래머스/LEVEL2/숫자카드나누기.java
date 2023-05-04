package 프로그래머스.LEVEL2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class 숫자카드나누기 {


    public int sosu(int a,int b){

        BigInteger x = BigInteger.valueOf(a);
        BigInteger y = BigInteger.valueOf(b);
        BigInteger rtn = x.gcd(y);
        return rtn.intValue();
    }


    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        //A배열에 대한 최대공약수
        int a = arrayA[0];
        for(int i=1;i<arrayA.length;i++)
            a = sosu(a,arrayA[i]);

        //B배열에 대한 최대공약수
        int b = arrayB[0];
        for(int i=1;i<arrayB.length;i++)
            b = sosu(b,arrayB[i]);



        if(a==1&&b==1)
            return 0;

        int sosuA = (int)Math.sqrt(a);
        int sosuB = (int)Math.sqrt(b);
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        for(int i=1;i<=sosuA;i++){
            if(a%i==0){
                aSet.add(a);
                aSet.add(a/i);
            }
        }

        for(int i=1;i<=sosuB;i++){
            if(b%i==0){
                bSet.add(b);
                bSet.add(b/i);
            }
        }

        for(int x : aSet){
            boolean isAns = true;
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i]%x==0){
                    isAns= false;
                    break;
                }
            }

            if(isAns)
                if(x>answer)
                    answer = x;
        }

        for(int x : bSet){
            boolean isAns = true;
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i]%x==0){
                    isAns= false;
                    break;
                }
            }
            if(isAns)
                if(x>answer)
                    answer = x;
        }

        //case 1  A에서 B를 나눌 수 있는지
        return answer==1?0:answer;
    }
}
