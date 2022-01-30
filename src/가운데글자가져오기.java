public class 가운데글자가져오기 {
    public String solution(String s) {
        if(s.length()==1){
            return s;
        }
        StringBuffer stBuffer = new StringBuffer(s);
        String temp ="";
        if(stBuffer.length()%2==0){
            temp +=stBuffer.charAt(stBuffer.length()/2-1);
            temp += stBuffer.charAt(stBuffer.length()/2);
            return temp;
        }
        else{
            temp += stBuffer.charAt(stBuffer.length()/2);
            return temp;
        }
    }
}
