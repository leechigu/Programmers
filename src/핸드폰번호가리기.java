public class 핸드폰번호가리기 {
    public String solution(String phone_number) {

        String answer = "";
        int len = phone_number.length();
        if(len==4) {
            return phone_number;
        }
        for(int i=0;i<len-4;i++)
            answer +="*";
        String temp = phone_number.substring(len-4,len);
        answer +=temp;
        return answer;
    }

}
