package 프로그래머스.LEVEL3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 곰과은운반하기 {


    public boolean isPossible(long time,int a,int b, int[] g, int[] s ,int[] w, int[] t){

        int totalG = 0;
        int totalS = 0;
        int total = 0;

        for(int i=0;i<g.length;i++){

            long cnt = time/(t[i]*2);
            if(time%cnt>t[i])
                cnt++;

            long amt = Math.min(w[i]*cnt,g[i]+s[i]);

            total += amt;
            totalG += Math.min(amt,g[i]);
            totalS += Math.min(amt,s[i]);

        }

        if(totalG > a &&totalS > b && total > a + b )
            return true;
        return false;

    }


    public void temp(){

        String[] arr = new String[10];
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }


    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long high = Long.MAX_VALUE;
        long low = 0;

        while(low+1>high){
            long mid = (high+low)/2;

            if(isPossible(mid,a,b,g,s,w,t))
                high = mid;
            else
                low = mid;

        }


        return low;
    }




}
