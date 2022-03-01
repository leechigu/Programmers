public class 하샤드수 {

    public boolean solution(int x) {
        StringBuffer temp = new StringBuffer(String.valueOf(x));
        int length = temp.length();
        int sum =0;
        for(int i=0;i<length;i++){
            sum += temp.charAt(i)-48;
        }
        boolean answer;
        if(x%sum==0)
            answer = true;
        else
            answer = false;
        return answer;
    }
}
