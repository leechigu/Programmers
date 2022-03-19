public class 조이스틱 {

    static int idx;
    static int cnt;

    public int changeChar(char res){
        int cnt = res-'A';
        if(cnt>=13){
            cnt = cnt-13;
            cnt = 13-cnt;
        }
        return cnt;
    }

    public int findNext(int curIndx,String name){

        int temp =curIndx;

        int rCnt =0;
        int lCnt =0;

        while(true){
            if(curIndx==name.length()-1){
                curIndx=-1;
            }
            if(rCnt == name.length()){
                return -1;
            }
            curIndx++;
            rCnt++;
            if(name.charAt(curIndx)!='A'){
                break;
            }
        }
        curIndx =temp;
        while(true) {
            if (curIndx == 0) {
                curIndx = name.length();
            }
            if(lCnt == name.length()){
                return -1;
            }
            curIndx--;
            lCnt++;
            if (name.charAt(curIndx) != 'A') {
                break;
            }
        }
        if(rCnt>=lCnt) {
            cnt += lCnt;
            System.out.println("find Cnt ="+lCnt);
        }
        else {
            cnt += rCnt;
            System.out.println("find Cnt ="+rCnt);
        }
        return curIndx;
    }

    public int solution(String name) {
        StringBuffer sb = new StringBuffer(name);
        cnt = 0;
        String aString = "";
        for(int i=0;i<name.length();i++)
            aString+='A';
        idx =0;
        while(true){
            if(sb.toString().equals(aString))
                break;
            if(sb.charAt(idx)=='A'){
                idx =findNext(idx,sb.toString());
            }
            int change =changeChar(sb.charAt(idx));
            cnt+=change;
            System.out.println("change Cnt ="+change);
            sb.setCharAt(idx,'A');
            idx =findNext(idx,sb.toString());
        }
        return cnt;
    }

}
