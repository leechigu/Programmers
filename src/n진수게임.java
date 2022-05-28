public class n진수게임 {


    public String setWlsqjq(int n,int curNum,char[] c){

        if(curNum==0)
            return "0";
        String rtn = "";
        while(true){
            if(curNum==0){
                break;
            }
            rtn = c[(curNum%n)]+rtn;
            curNum /= n;
        }
        System.out.println(rtn);
        return rtn;
    }



    public String solution(int n, int t, int m, int p) {
        String answer = "";


        int lastCnt = (t * m) + p;
        int curNum = 0;
        char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        String temp ="";
        int cnt = 0;
        boolean isFinish = false;
        while(true){
            String wlstn =setWlsqjq(n,curNum,c);
            for(int i=0;i<wlstn.length();i++){
                temp+=wlstn.charAt(i);
                cnt++;
                if(cnt == lastCnt-1){
                    isFinish = true;
                    break;
                }

            }
            curNum++;
            if(isFinish)
                break;

        }
        System.out.println(temp);
        for(int i=p-1;i<temp.length();i+=m){
            answer += temp.charAt(i);
        }

        return answer;

        // 0 1 2 3 4 5 6 7 8 9  10 12 13 14 15
        // 0 1 2 3 4 5 6 7 8 9   A  B  C  D  E
    }
}
