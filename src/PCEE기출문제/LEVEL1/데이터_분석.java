package PCEE기출문제.LEVEL1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 데이터_분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        String[] extList = {"code","date","maximum","remain"};


        int extListIndx =-1;

        for(int i=0;i<4;i++){
            if(ext.equals(extList[i])){
                extListIndx = i;
                break;
            }
        }
        ArrayList<int[]> arrList = new ArrayList<>();

        for(int i=0; i<data.length;i++){

            int[] tempData = data[i];
            int val = tempData[extListIndx];

            if(val<val_ext){
                arrList.add(tempData);
            }
        }

        int finalExtListIndx = extListIndx;
        Collections.sort(arrList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int temp = finalExtListIndx;
                return o1[temp]-o2[temp];
            }
        });

        int[][] answer = arrList.toArray(new int[0][]);


        return answer;
    }
}
