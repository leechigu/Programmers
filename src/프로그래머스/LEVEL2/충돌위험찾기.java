package 프로그래머스.LEVEL2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class 충돌위험찾기 {


    public void calRoute(int a,int b,int c,int d,ArrayList<int[]> arrayList){
        // (a,b) -> (c,d)
        int totalLen = (c-a)-(d-b);

        for(int i=0;i<totalLen;i++){
            if(c!=a)
                a = c>a?a+1:a-1;
            else
                b = d>b?b+1:b-1;
            arrayList.add(new int[]{a,b});
        }
    }

    public int solution(int[][] points, int[][] routes) {

        int answer = 0;

        ArrayList<ArrayList<int[]>> arrList = new ArrayList<>();


        for(int[] route : routes){
            int prevIndx = route[0]-1;
            ArrayList<int[]> arr = new ArrayList<>();

            for(int i = 1;i<route.length;i++){
                int indx = route[i]-1;

                int[] prevPoint = points[prevIndx];
                int prevR = prevPoint[0];
                int prevC = prevPoint[1];

                int[] point = points[indx];
                int r = point[0];
                int c = point[1];

                calRoute(prevR,prevC,r,c,arr);

                prevIndx = indx;
            }
            arrList.add(arr);
        }

        int maxLen = Integer.MIN_VALUE;

        for(int i = 0 ;i<arrList.size();i++){
            int size = arrList.get(i).size();
            maxLen = Math.max(size, maxLen);
        }

        for(int i=0;i<maxLen;i++){

            Map<String,Integer> map  = new HashMap<>();

            for(int j=0;j<arrList.size();j++){
                ArrayList<int[]> arr = arrList.get(j);
                if(arr.size()==i){
                    arrList.remove(j);
                    j--;
                    continue;
                }
                int[] curRoute = arr.get(i);

                String key = String.valueOf(curRoute[0])+","+String.valueOf(curRoute[1]);

                System.out.println(key);

                if(map.containsKey(key)){
                    int value = map.get(key);
                    map.put(key,value+1);
                }else{
                    map.put(key,1);
                }
            }

            for(String key : map.keySet()){
                if(map.get(key)>1){
                    System.out.println(key);
                    answer++;
                }
            }
        }


        return answer;
    }
}