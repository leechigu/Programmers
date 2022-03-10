import java.util.ArrayList;

public class 거리두기확인하기 {

    public int menhathonLength(int x1,int y1,int x2,int y2){
        int x = x1 -x2;
        int y = y1 -y2;
        x = x>0? x: x*-1;
        y = y>0? y: y*-1;
        return x+y;
    }
    public boolean check(String[] place, int y1,int x1,int y2,int x2){

        if(y1==y2){
            String temp = place[y1];
            if(temp.charAt((x2+x1)/2)=='X')
                return true;
            else
                return false;
        }
        // 세로로 한줄인지
        if(x1==x2){
            String temp = place[(y2+y1)/2];
            if(temp.charAt(x1)=='X')
                return true;
            else
                return false;
        }
        // 사각형인지
        int a1,b1,a2,b2;
        a1 = x1; b1 = y2;
        a2 = x2; b2 = y1;
        if(place[b1].charAt(a1)=='X'&&place[b2].charAt(a2)=='X')
            return true;
        else
            return false;
    }


    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<5;i++){
            ArrayList<int[]> arr = new ArrayList<>();
            ArrayList<int[]> partitions = new ArrayList<>();
            for(int j=0;j<5;j++){
                String temp =places[i][j];
                for(int k=0;k<5;k++){
                    if(temp.charAt(k)=='P'){
                        int[] tempArr = new int[2];
                        tempArr[0] = j;
                        tempArr[1] = k;
                        arr.add(tempArr);
                    }
                    else if(temp.charAt(k)=='X'){
                        int[] tempArr = new int[2];
                        tempArr[0] = j;
                        tempArr[1] = k;
                        partitions.add(tempArr);
                    }
                }
            }
            boolean isGood =true;
            for(int j=0;j<arr.size()-1;j++){
                for(int k=j+1;k<arr.size();k++){
                    int x1,y1,x2,y2;
                    int[] te = arr.get(j);
                    x1 = te[0];
                    y1 = te[1];
                    te = arr.get(k);
                    x2 = te[0];
                    y2 = te[1];
                    int length = menhathonLength(x1,y1,x2,y2);
                    if(length==2){
                        if(!check(places[i],x1,y1,x2,y2)) {
                            isGood = false;
                            break;
                        }
                    }
                    else if(length==1){
                        isGood = false;
                        break;
                    }
                }
                if(isGood==false)
                    break;
            }
            if(isGood)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
}
