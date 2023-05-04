package 프로그래머스.LEVEL2;

import java.util.*;
public class 당구연습 {

    public long cal(int a,int b,int x,int y,boolean ehddlf){

        int xLen = a-x;
        int yLen = y-b;

        if(ehddlf)
            return Long.MAX_VALUE;

        return xLen*xLen+yLen*yLen;
    }


    public long calLen(int m,int n,int x,int y, int[] ball){

        long[] rtns = new long[4];

        boolean isXLine = false;
        boolean isYLine = false;
        int a = ball[0];
        int b = ball[1];

        if(a==x){
            isYLine = true;
        }

        if(b==y){
            isXLine = true;
        }

        boolean isStuck = false;
        //case1 좌측선에 대해서 대칭
        int temp = x*-1;
        if(isXLine){
            if(temp<a&&a<x)
                isStuck = true;
        }

        rtns[0] = cal(a,b,temp,y,isStuck);
        isStuck = false;

        //case2 우측선에 대해서 대칭
        int tempVal = x;
        temp = 2 * m - tempVal;

        if(isXLine){
            if(x<a&&a<temp)
                isStuck = true;
        }

        rtns[1] = cal(a,b,temp,y,isStuck);
        isStuck = false;

        //case3 위쪽선에 대해서 대칭
        temp = 2 * n - y;
        if(isYLine){
            if(y<b&&b<temp)
                isStuck = true;
        }
        rtns[2] = cal(a,b,x,temp,isStuck);
        isStuck = false;

        //case4 아래쪽선에 대해서 대칭
        temp = y*-1;
        if(isYLine){
            if(temp<b&&b<y)
                isStuck = true;
        }
        rtns[3] = cal(a,b,x,temp,isStuck);


        Arrays.sort(rtns);
        return rtns[0];
    }

    public long[] solution(int m, int n, int startX, int startY, int[][] balls) {
        long[] answer = new long[balls.length];


        for(int i=0;i<balls.length;i++)
            answer[i]=calLen(m,n,startX,startY,balls[i]);
        return answer;
    }

}
