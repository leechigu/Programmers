public class 김서방찾기 {
    public String solution(String[] seoul) {
        int num =-1;
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                num = i;
            }
        }
        return "김서방은 "+num+"에 있다";
    }
}
