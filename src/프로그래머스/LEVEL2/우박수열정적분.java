package 프로그래머스.LEVEL2;


import java.util.*;

public class 우박수열정적분 {
    private double calSize(int a, int b){

        int min = Math.min(a,b);
        int max = Math.max(a,b);

        return min+(double)(max-min)/2;
    }


    public double[] solution(int k, int[][] ranges) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(k);
        while(true){
            if(k==1){
                break;
            }
            if(k%2 == 0){
                k = k/2;
                arrayList.add(k);
            }
            else{
                k= k*3 +1;
                arrayList.add(k);
            }

        }


        ArrayList<Double> arrSize = new ArrayList<>();

        for(int i=0;i<arrayList.size()-1;i++){
            int cur = arrayList.get(i);
            int next = arrayList.get(i+1);

            double size = calSize(cur,next);
            arrSize.add(size);
        }

        ArrayList<Double> ans = new ArrayList<>();

        for(int i=0;i<ranges.length;i++){

            int a = ranges[i][0];
            int b = ranges[i][1];

            if(arrSize.size()+b<a){
                ans.add((double)-1);
                continue;
            }

            double value = 0;

            for(int j=a;j<arrSize.size()+b;j++){
                value +=arrSize.get(j);
            }

            ans.add(value);

        }

        double[] answer = new double[ans.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }


        return answer;
    }

}
