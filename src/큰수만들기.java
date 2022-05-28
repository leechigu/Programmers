public class 큰수만들기 {

    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer(number);
        for(int i=0;i<k;i++){
            for(int j=0;j<sb.length()-1;j++){
                if(sb.charAt(j)<sb.charAt(j+1)){
                    sb.deleteCharAt(j);
                    break;
                }
                if(j==sb.length()-2&&sb.charAt(j)==sb.charAt(j+1)){
                    sb.deleteCharAt(j);
                }

            }
        }
        String answer = sb.toString();
        return answer;
    }
}
